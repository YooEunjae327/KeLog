package com.temp.kelog.domain.kelog.repository;

import com.temp.kelog.domain.kelog.entity.Kelog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface KelogRepositroy extends JpaRepository<Kelog, Long> { }
