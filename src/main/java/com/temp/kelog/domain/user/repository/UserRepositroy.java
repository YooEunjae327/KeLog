package com.temp.kelog.domain.user.repository;

import com.temp.kelog.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositroy extends JpaRepository<User, Long> {

    //boolean findByEmail(String email);

    Optional<User> findByEmail(String email);
}