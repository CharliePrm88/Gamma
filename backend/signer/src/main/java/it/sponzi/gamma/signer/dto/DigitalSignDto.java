package it.sponzi.gamma.signer.dto;

import it.sponzi.gamma.common.dto.BaseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.security.PrivateKey;
import java.security.PublicKey;

@Data
public class DigitalSignDto extends BaseDto {

    @NotBlank
    protected String user;

    protected PrivateKey privateKey;

    protected PublicKey publicKey;
}
