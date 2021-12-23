package com.fundamentos.spring.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping
//    @RequestBody
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("hello from controller", HttpStatus.OK);
    }
}
