package com.temp.kelog.domain.user.repository;

import com.temp.kelog.domain.user.entity.UserSocialInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSocialInfoRepository extends JpaRepository<UserSocialInfo, Long> {
}
