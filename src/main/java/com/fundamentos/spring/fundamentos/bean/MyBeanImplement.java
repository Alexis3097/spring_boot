package com.fundamentos.spring.fundamentos.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("hola desde my implementacion propia de bean");
    }
}
