package it.sponzi.gamma.pec.dto;

import it.sponzi.gamma.common.dto.BaseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.NavigableSet;
import java.util.TreeSet;

@Data
@EqualsAndHashCode(callSuper = true)
public class PecMailDto extends BaseDto {

    @NotBlank
    protected String name;
    @Valid
    protected NavigableSet<PecDto> pecs = new TreeSet<>();
}
