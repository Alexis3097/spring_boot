package com.fundamentos.spring.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class componentImplementTwo implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola mundo uwu 2");
    }
}
