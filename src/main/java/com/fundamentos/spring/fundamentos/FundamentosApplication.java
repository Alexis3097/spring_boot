package com.fundamentos.spring.fundamentos;

import com.fundamentos.spring.fundamentos.bean.MyBean;
import com.fundamentos.spring.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.spring.fundamentos.bean.MyOwnDependency;
import com.fundamentos.spring.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyOwnDependency myOwnDependency;

    @Autowired
    public FundamentosApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyOwnDependency myOwnDependency) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myOwnDependency = myOwnDependency;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.saludar();
        myBean.print();
        myBeanWithDependency.printWithDependency();
        myOwnDependency.MyMethod();
    }
}
