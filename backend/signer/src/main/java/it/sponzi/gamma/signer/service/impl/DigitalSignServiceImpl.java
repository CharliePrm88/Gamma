package it.sponzi.gamma.signer.service.impl;

import it.sponzi.gamma.common.exception.InternalException;
import it.sponzi.gamma.common.service.BaseServiceImpl;
import it.sponzi.gamma.signer.dao.DigitalSign;
import it.sponzi.gamma.signer.dto.DigitalSignDto;
import it.sponzi.gamma.signer.repository.DigitalSignRepository;
import it.sponzi.gamma.signer.service.DigitalSignService;
import it.sponzi.gamma.signer.service.mapper.DigitalSignMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Service
@Slf4j
public class DigitalSignServiceImpl extends BaseServiceImpl<DigitalSign, DigitalSignDto> implements DigitalSignService {

    private final DigitalSignRepository digitalSignRepository;

    @Autowired
    public DigitalSignServiceImpl(DigitalSignRepository repository, DigitalSignMapper mapper) {
        super(repository, mapper, DigitalSign.class);
        this.digitalSignRepository = repository;
    }

    @Override
    public Mono<DigitalSignDto> create(DigitalSignDto dtoToBeSaved) {
        try {
            DigitalSign digitalSign = mapper.toDao(dtoToBeSaved);
            KeyPairGenerator generator = KeyPairGenerator.getInstance("SHA256withRSA");
            generator.initialize(2048);
            KeyPair pair = generator.generateKeyPair();
            digitalSign.setPublicKey(pair.getPublic().getEncoded());
            digitalSign.setPrivateKey(pair.getPrivate().getEncoded());
            return Mono.just(repository.save(digitalSign)).map(mapper::toDto);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getLocalizedMessage());
            throw new InternalException("Something gone wrong generating a new private key");
        }
    }

    @Override
    public Mono<DigitalSignDto> update(DigitalSignDto dtoToBeSaved) {
        return this.create(dtoToBeSaved);
    }

    @Override
    public Mono<byte[]> signDocument(String user, byte[] data) {
        try {
            DigitalSign dao = digitalSignRepository.findByUser(user);
            Signature sig = Signature.getInstance("SHA256withRSA");
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = kf.generatePrivate(new PKCS8EncodedKeySpec(dao.getPrivateKey()));
            sig.initSign(privateKey);
            sig.update(data);
            byte[] signatureBytes = sig.sign();
            return Mono.just(signatureBytes);
        } catch (NoSuchAlgorithmException | SignatureException e) {
            log.error(e.getLocalizedMessage());
            throw new InternalException("Something gone wrong signing the document", e);
        } catch (InvalidKeyException | InvalidKeySpecException e) {
            log.error(e.getLocalizedMessage());
            throw new InternalException("Your private key is invalid", e);
        }
    }

    @Override
    public Mono<Boolean> verify(String user, byte[] data) {
        try {
            DigitalSign dao = digitalSignRepository.findByUser(user);
            Signature publicSignature = Signature.getInstance("SHA256withRSA");
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PublicKey publicKey = kf.generatePublic(new X509EncodedKeySpec(dao.getPublicKey()));
            publicSignature.initVerify(publicKey);
            publicSignature.update(data);
            boolean valid = publicSignature.verify(data);
            return Mono.just(valid);
        } catch (NoSuchAlgorithmException | SignatureException e) {
            log.error(e.getLocalizedMessage());
            throw new InternalException("Something gone wrong signing the document", e);
        } catch (InvalidKeyException | InvalidKeySpecException e) {
            log.error(e.getLocalizedMessage());
            throw new InternalException("Your private key is invalid", e);
        }
    }

}
