package it.sponzi.gamma.pec.service.impl;

import it.sponzi.gamma.common.service.BaseServiceImpl;
import it.sponzi.gamma.pec.dto.UserDto;
import it.sponzi.gamma.pec.dao.Users;
import it.sponzi.gamma.pec.repository.UserRepository;
import it.sponzi.gamma.pec.service.UserService;
import it.sponzi.gamma.pec.service.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<Users, UserDto> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper){
        super(repository, mapper, Users.class);
    }
}
