package com.fundamentos.spring.fundamentos;

import com.fundamentos.spring.fundamentos.bean.MyBean;
import com.fundamentos.spring.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.spring.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.spring.fundamentos.bean.MyOwnDependency;
import com.fundamentos.spring.fundamentos.component.ComponentDependency;
import com.fundamentos.spring.fundamentos.entity.User;
import com.fundamentos.spring.fundamentos.pojo.UserPojo;
import com.fundamentos.spring.fundamentos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyOwnDependency myOwnDependency;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;
    private UserRepository userRepository;

    @Autowired
    public FundamentosApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency,
                                  MyBean myBean,
                                  MyBeanWithDependency myBeanWithDependency,
                                  MyOwnDependency myOwnDependency,
                                  MyBeanWithProperties myBeanWithProperties,
                                  UserPojo userPojo,
                                  UserRepository userRepository
    ) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myOwnDependency = myOwnDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        classesPasadas();
        saveUserInDDBB();

    }

    private void saveUserInDDBB() {
        User user1 = new User("Alexis", "alex@gmail.com", LocalDate.now());
        User user2 = new User("Jose", "Jose@gmail.com", LocalDate.now());
        User user3 = new User("pedro", "pedro@gmail.com", LocalDate.now());
        User user4 = new User("Raul", "Raul@gmail.com", LocalDate.now());
        User user5 = new User("Mario", "Mario@gmail.com", LocalDate.now());
        User user6 = new User("Saul", "Saul@gmail.com", LocalDate.now());
        User user7 = new User("Roxana", "Roxana@gmail.com", LocalDate.now());
        List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);
        userList.stream().forEach(userRepository::save);
    }

    public void classesPasadas() {
        componentDependency.saludar();
        myBean.print();
        myBeanWithDependency.printWithDependency();
        myOwnDependency.MyMethod();
        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail());
    }
}
