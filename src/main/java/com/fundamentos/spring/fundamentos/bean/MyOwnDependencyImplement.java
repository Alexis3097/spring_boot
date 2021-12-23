package com.fundamentos.spring.fundamentos.bean;

public class MyOwnDependencyImplement implements MyOwnDependency{
    @Override
    public void MyMethod() {
        System.out.println("Ya ando al tiro");
    }
}
