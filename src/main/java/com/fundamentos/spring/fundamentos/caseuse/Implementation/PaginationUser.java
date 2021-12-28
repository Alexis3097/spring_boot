package com.fundamentos.spring.fundamentos.caseuse.Implementation;

import com.fundamentos.spring.fundamentos.caseuse.Interface.IPaginationUser;
import com.fundamentos.spring.fundamentos.entity.User;
import com.fundamentos.spring.fundamentos.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PaginationUser implements IPaginationUser {
    private UserService userService;

    public PaginationUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userService.findAll(Pageable pageable);
    }
}
