package it.sponzi.gamma.pec.service.mapper;

import it.sponzi.gamma.common.service.mapper.BaseMapper;
import it.sponzi.gamma.pec.dao.Users;
import it.sponzi.gamma.pec.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<Users, UserDto> {

}
