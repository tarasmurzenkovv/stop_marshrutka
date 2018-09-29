package com.stop_marshrutka.backend.service;

import com.stop_marshrutka.backend.model.dto.UserDto;
import com.stop_marshrutka.backend.model.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserEntity toUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUserName(userDto.getUserName());

        return userEntity;
    }

    public UserDto toUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();

        userDto.setUserId(userEntity.getId());
        userDto.setUserName(userEntity.getUserName());

        return userDto;
    }
}
