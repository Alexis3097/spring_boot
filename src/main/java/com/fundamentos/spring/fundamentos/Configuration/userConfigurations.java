package com.fundamentos.spring.fundamentos.Configuration;

import com.fundamentos.spring.fundamentos.caseuse.Implementation.*;
import com.fundamentos.spring.fundamentos.caseuse.Interface.*;
import com.fundamentos.spring.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class userConfigurations {
    @Bean
    IGetUser getUser(UserService userService) {
        return new GetUser(userService);
    }

    @Bean
    ICreateUser createUser(UserService userService) {
        return new CreateUser(userService);
    }

    @Bean
    IDeleteUser deleteUser(UserService userService) {
        return new DeleteUser(userService);
    }

    @Bean
    IUpdateUser updateUser(UserService userService) {
        return new UpdateUser(userService);
    }

    @Bean
    IPaginationUser paginationUser(UserService userService) {
        return new PaginationUser (userService);
    }
}
