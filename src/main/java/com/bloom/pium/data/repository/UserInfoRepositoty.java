package com.bloom.pium.data.repository;

import com.bloom.pium.data.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepositoty extends JpaRepository<UserInfo,Long> {

    UserInfo findByUsername(String username);
}
