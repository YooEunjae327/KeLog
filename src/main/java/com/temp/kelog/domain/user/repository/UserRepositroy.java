package com.temp.kelog.domain.user.repository;

import com.temp.kelog.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepositroy extends JpaRepository<User, Long> { }