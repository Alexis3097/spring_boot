package com.fundamentos.spring.fundamentos.caseuse.Implementation;

import com.fundamentos.spring.fundamentos.caseuse.Interface.IDeleteUser;
import com.fundamentos.spring.fundamentos.service.UserService;

public class DeleteUser implements IDeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void remove(Long id) {
        userService.remove(id);
    }
}
