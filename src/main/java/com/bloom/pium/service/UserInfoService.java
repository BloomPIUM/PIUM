package com.bloom.pium.service;

import com.bloom.pium.data.dto.BoardResponseDto;
import com.bloom.pium.data.dto.UserInfoDto;
import com.bloom.pium.data.dto.UserinfoResponseDto;
import com.bloom.pium.data.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    // 이름 유일성 확인
    public boolean isUsernameUnique(String username );
    // 회원가입
    public UserInfoDto join(UserInfoDto userInfoDto);
    // 회원 조회
    //유저 정보 조회
    UserInfo getUserInfoByUsername(String username);
    UserinfoResponseDto findUsername(String username);
    // 비밀번호 일치 확인
    // 내 정보
    UserInfo getUserInfoByUserId(Long userId);
}
