package com.fundamentos.spring.fundamentos.caseuse.Implementation;

import com.fundamentos.spring.fundamentos.caseuse.Interface.IUpdateUser;
import com.fundamentos.spring.fundamentos.entity.User;
import com.fundamentos.spring.fundamentos.service.UserService;

public class UpdateUser implements IUpdateUser {
    private UserService userService;
    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User update(User user, Long id) {
        return userService.update(user, id);
    }
}
