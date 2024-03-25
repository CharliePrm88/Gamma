package it.sponzi.gamma.pec.dto;

import it.sponzi.gamma.common.dto.BaseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Valid
public class UserDto extends BaseDto {

    @NotBlank
    protected String name;

    @NotBlank
    protected String surname;

    @Past
    protected Instant bornDate;

    @NotEmpty
    protected Set<RoleDto> roles = new HashSet<>();

    @Valid
    protected Set<PecMailDto> pecMails = new HashSet<>();
}
