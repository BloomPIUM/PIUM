package com.bloom.pium.service.impl;

import com.bloom.pium.data.dto.UserInfoDto;
import com.bloom.pium.data.entity.UserInfo;
import com.bloom.pium.data.repository.UserInfoRepository;
import com.bloom.pium.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl  implements UserInfoService {

    private UserInfoRepository userInfoRepository;

    @Autowired
    public  UserInfoServiceImpl(UserInfoRepository userInfoRepository){
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public boolean isUsernameUnique(String username) {
        UserInfo existingUser = userInfoRepository.findByUsername(username);
        return existingUser == null;
    }

    @Override
    public UserInfoDto join(UserInfoDto userInfoDto) {
        UserInfo user = new UserInfo();
        user.setUsername(userInfoDto.getUsername());
        user.setPassword(userInfoDto.getPassword());
        user.setName(userInfoDto.getName());
        user.setPhone(userInfoDto.getPhone());
        user.setGender(userInfoDto.getGender());
        user.setStatus("일반");
        userInfoRepository.save(user);

        return userInfoDto;
    }

    @Override
    public UserInfoDto findUsername(String username) {
        UserInfo user= userInfoRepository.findByUsername(username);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUsername(user.getUsername());
        userInfoDto.setPassword(user.getPassword());
        return userInfoDto;
    }


}
