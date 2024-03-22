package it.sponzi.gamma.common.service.mapper;

import it.sponzi.gamma.common.dao.BaseDao;
import it.sponzi.gamma.common.dto.BaseDto;

public interface BaseMapper<T extends BaseDao, M extends BaseDto> {

    M toDto(T dao);

    T toDao(M dto);

}
