package it.sponzi.gamma.storer.service.mapper;

import it.sponzi.gamma.common.service.mapper.BaseMapper;
import it.sponzi.gamma.storer.dao.StoredData;
import it.sponzi.gamma.storer.dto.StoredDataDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoredMapper extends BaseMapper<StoredData, StoredDataDto> {
}
