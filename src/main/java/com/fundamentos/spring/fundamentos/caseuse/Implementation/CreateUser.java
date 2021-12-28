package com.fundamentos.spring.fundamentos.caseuse.Implementation;

import com.fundamentos.spring.fundamentos.caseuse.Interface.ICreateUser;
import com.fundamentos.spring.fundamentos.entity.User;
import com.fundamentos.spring.fundamentos.service.UserService;

public class CreateUser implements ICreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }
    @Override
    public User saveUser(User user) {
        return userService.saveUser(user);
    }
}
