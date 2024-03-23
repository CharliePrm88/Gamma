package it.sponzi.gamma.signer.service.mapper;

import it.sponzi.gamma.common.service.mapper.BaseMapper;
import it.sponzi.gamma.signer.dao.DigitalSign;
import it.sponzi.gamma.signer.dto.DigitalSignDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DigitalSignMapper  extends BaseMapper<DigitalSign, DigitalSignDto> {

    @Override
    @Mapping(target = "privateKey", ignore = true)
    DigitalSignDto toDto(DigitalSign dao);
}
