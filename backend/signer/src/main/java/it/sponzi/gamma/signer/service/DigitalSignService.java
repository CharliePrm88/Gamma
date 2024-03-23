package it.sponzi.gamma.signer.service;

import it.sponzi.gamma.common.service.BaseService;
import it.sponzi.gamma.signer.dao.DigitalSign;
import it.sponzi.gamma.signer.dto.DigitalSignDto;
import reactor.core.publisher.Mono;

public interface DigitalSignService extends BaseService<DigitalSign, DigitalSignDto> {
    Mono<byte[]> signDocument(String user, byte[] data);

    Mono<Boolean> verify(String user, byte[] data);

}
