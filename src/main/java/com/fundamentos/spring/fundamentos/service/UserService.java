package com.fundamentos.spring.fundamentos.service;

import com.fundamentos.spring.fundamentos.entity.User;
import com.fundamentos.spring.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log log = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users) {
        users.stream().peek(user -> log.info("Insertando usuario: " + user))
                .forEach(userRepository::save);
//                .forEach(user -> userRepository.save(user));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.delete(new User(id));
    }

    public User update(User newUser, Long id){
        return userRepository.findById(id).map(user -> {
            user.setEmail(newUser.getEmail());
            user.setBirthDate(newUser.getBirthDate());
            user.setName(newUser.getName());
            return userRepository.save(user);
        }).orElse(null);
    }

    public Page<User> findAll(Pageable pageable) {

    }
}
