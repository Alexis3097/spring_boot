package com.fundamentos.spring.fundamentos.caseuse.Interface;

import com.fundamentos.spring.fundamentos.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPaginationUser {
    Page<User> findAll(Pageable pageable);
}
