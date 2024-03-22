package it.sponzi.gamma.pec.service.mapper;

import it.sponzi.gamma.common.service.mapper.BaseMapper;
import it.sponzi.gamma.pec.dao.PecMail;
import it.sponzi.gamma.pec.dto.PecMailDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PecMailMapper extends BaseMapper<PecMail, PecMailDto> {
}
