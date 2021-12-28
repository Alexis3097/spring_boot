package com.fundamentos.spring.fundamentos;

import com.fundamentos.spring.fundamentos.bean.*;
import com.fundamentos.spring.fundamentos.component.ComponentDependency;
import com.fundamentos.spring.fundamentos.entity.User;
import com.fundamentos.spring.fundamentos.pojo.UserPojo;
import com.fundamentos.spring.fundamentos.repository.UserRepository;
import com.fundamentos.spring.fundamentos.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
    private final Log log = LogFactory.getLog(FundamentosApplication.class);
    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyOwnDependency myOwnDependency;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;
    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public FundamentosApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency,
                                  MyBean myBean,
                                  MyBeanWithDependency myBeanWithDependency,
                                  MyOwnDependency myOwnDependency,
                                  MyBeanWithProperties myBeanWithProperties,
                                  UserPojo userPojo,
                                  UserRepository userRepository,
                                  UserService userService
    ) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myOwnDependency = myOwnDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        classesPasadas();
        saveUserInDDBB();
        getInformationJpqlFromUser();
        saveUserWithError();
    }

    private void saveUserInDDBB() {
        User user1 = new User("Alexis", "alex@gmail.com", LocalDate.of(2021, 12, 27));
        User user2 = new User("Ale", "Jose@gmail.com", LocalDate.now());
        User user3 = new User("pedro", "pedro@gmail.com", LocalDate.now());
        User user4 = new User("Raul", "Raul@gmail.com", LocalDate.now());
        User user5 = new User("Mario", "Mario@gmail.com", LocalDate.now());
        User user6 = new User("Saul", "Saul@gmail.com", LocalDate.now());
        User user7 = new User("Roxana", "Roxana@gmail.com", LocalDate.now());
        List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);
        userList.stream().forEach(userRepository::save);
    }

    private void getInformationJpqlFromUser() {
//        log.info("Usuario " + userRepository.findByUserEmail("alex@gmail.com").orElseThrow(() -> new RuntimeException("no se encontro el usuario")));
//
//        userRepository.findAndSort("Ale", Sort.by("id").descending()).stream().forEach(user -> log.info("El usuario: " + user));
//
//        userRepository.findByName("Alexis").stream().forEach(user -> log.info("Usuario con query method " + user));
//        log.info(userRepository.findByEmailAndName("Jose@gmail.com", "Ale").orElseThrow(()->new RuntimeException("No se encontro al usuario")));
//        userRepository.findByEmailLike("%Saul%").forEach(user -> log.info("Usuario: " + user));
//        userRepository.findByNameOrEmail("Ale", null).forEach(user -> log.info("name or email : " + user));
        log.info("--------------------" + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021, 12, 27), "alex@gmail.com").orElseThrow(() -> new RuntimeException("no hay nada uwu")));
    }

    private void saveUserWithError() {
        User user1 = new User("TestName1", "Test1@gmail.com", LocalDate.now());
        User user2 = new User("TestName2", "Test2@gmail.com", LocalDate.now());
        User user3 = new User("TestName3", "Test3@gmail.com", LocalDate.now());
        User user4 = new User("TestName4", "Tes4t@gmail.com", LocalDate.now());
        List<User> users = Arrays.asList(user1, user2, user3, user4);
       try{
           userService.saveTransactional(users);
       }catch (Exception e){
           log.error("---------ERROR DE TRANSACCION----------");
       }
        userService.getAllUsers().stream().forEach(user -> log.info("TRANSACCION " + user));
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
