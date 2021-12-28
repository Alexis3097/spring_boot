package com.fundamentos.spring.fundamentos.controller;

import com.fundamentos.spring.fundamentos.caseuse.Implementation.PaginationUser;
import com.fundamentos.spring.fundamentos.caseuse.Interface.*;
import com.fundamentos.spring.fundamentos.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private IGetUser iGetUser;
    private ICreateUser iCreateUser;
    private IDeleteUser iDeleteUser;
    private IUpdateUser iUpdateUser;
    private IPaginationUser ipaginationUser;

    public UserController(IGetUser iGetUser, ICreateUser iCreateUser, IDeleteUser iDeleteUser, IUpdateUser iUpdateUser, IPaginationUser ipaginationUser) {
        this.iGetUser = iGetUser;
        this.iCreateUser = iCreateUser;
        this.iDeleteUser = iDeleteUser;
        this.iUpdateUser = iUpdateUser;
        this.ipaginationUser = ipaginationUser;
    }

    @GetMapping("/")
    List<User> get() {
        return iGetUser.getAll();
    }

    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser) {
        return new ResponseEntity<>(iCreateUser.saveUser(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deletUser(@PathVariable Long id) {
        iDeleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        return  new ResponseEntity<>(iUpdateUser.update(user, id), HttpStatus.OK);
    }

    @GetMapping("/pagination")
    public Page<User> getAlls(@PageableDefault(size = 10, page = 0) Pageable pageable){
        Page<User> list = ipaginationUser.findAll(pageable);
        return list;
    }

}
