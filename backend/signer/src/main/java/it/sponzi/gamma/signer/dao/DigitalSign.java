package it.sponzi.gamma.signer.dao;

import it.sponzi.gamma.common.dao.BaseDao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.security.PrivateKey;
import java.security.PublicKey;

@Table(name = "DIGITAL_SIGN")
@Entity(name = "DigitalSign")
@Data
public class DigitalSign implements BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ds")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "ds_seq", sequenceName = "seq_ds")
    protected Long id;

    protected String user;

    protected PrivateKey privateKey;

    protected PublicKey publicKey;

}
