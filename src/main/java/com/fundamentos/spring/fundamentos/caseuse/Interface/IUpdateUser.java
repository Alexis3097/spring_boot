package com.fundamentos.spring.fundamentos.caseuse.Interface;

import com.fundamentos.spring.fundamentos.entity.User;

public interface IUpdateUser {
    User update(User user, Long id);
}
