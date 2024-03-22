package it.sponzi.gamma.pec.service.impl;

import it.sponzi.gamma.common.service.BaseService;
import it.sponzi.gamma.common.service.BaseServiceImpl;
import it.sponzi.gamma.pec.dto.UserDto;
import it.sponzi.gamma.pec.dao.User;
import it.sponzi.gamma.pec.repository.UserRepository;
import it.sponzi.gamma.pec.service.UserService;
import it.sponzi.gamma.pec.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDto> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper){
        super(repository, mapper, User.class);
    }
}
