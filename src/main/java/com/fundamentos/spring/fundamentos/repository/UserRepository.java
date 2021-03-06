package com.fundamentos.spring.fundamentos.repository;

import com.fundamentos.spring.fundamentos.dto.UserDto;
import com.fundamentos.spring.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u FROM User u WHERE u.email=?1 ")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT  u from  User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);


    List<User> findByName(String name);
    List<User> findByEmailLike(String email);
    List<User> findByNameOrEmail(String name, String email);

    Optional<User> findByEmailAndName(String email, String name);
    @Query("select new com.fundamentos.spring.fundamentos.dto.UserDto(u.id, u.name, u.birthDate)" +
            " from User u " +
            " where u.birthDate=:parametroFecha" +
            " and u.email=:parametroEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date,
                                                @Param("parametroEmail") String email);
}
