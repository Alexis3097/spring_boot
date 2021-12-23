package com.fundamentos.spring.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {
    private MyOperation myOperation;
    Log log = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 1;
        System.out.println(myOperation.sum(number));
        System.out.println("Hola desde my bean con depedencencia");
        log.error("Ha ocurrido un error");
    }
}
