package it.sponzi.gamma.storer.dto;

import it.sponzi.gamma.common.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StoredDto extends BaseDto {

    protected byte[] fileSigned;

}
