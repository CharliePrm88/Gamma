package it.sponzi.gamma.pec.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.sponzi.gamma.common.controller.BaseController;
import it.sponzi.gamma.pec.dao.Users;
import it.sponzi.gamma.pec.dto.UserDto;
import it.sponzi.gamma.pec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name="User", description = "Api for User Management")
public class UserController extends BaseController<UserService, Users, UserDto> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }
}
