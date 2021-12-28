package com.fundamentos.spring.fundamentos.caseuse.Implementation;

import com.fundamentos.spring.fundamentos.caseuse.Interface.IGetUser;
import com.fundamentos.spring.fundamentos.entity.User;
import com.fundamentos.spring.fundamentos.service.UserService;

import java.util.List;

public class GetUser implements IGetUser {
private UserService userService;

    public GetUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
