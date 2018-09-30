package com.stop_marshrutka.backend.service;

import com.stop_marshrutka.backend.model.dto.UserDto;
import com.stop_marshrutka.backend.model.entities.UserEntity;
import com.stop_marshrutka.backend.model.entities.UserTypeEntity;
import com.stop_marshrutka.backend.repositories.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserMapper {
    private final UserTypeRepository userTypeRepository;

    public UserEntity toUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        UserTypeEntity userTypeEntity = userTypeRepository
                .findForStringValue(userDto.getUserType())
                .orElseThrow(() -> new RuntimeException("Cannot find for type" + userDto.getUserType().getType()));
        userEntity.setUserTypeEntity(userTypeEntity);
        userEntity.setUserName(userDto.getUserName());

        return userEntity;
    }

    public UserDto toUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();

        userDto.setUserId(userEntity.getId());
        userDto.setUserName(userEntity.getUserName());
        userDto.setUserType(userEntity.getUserTypeEntity().getUserType());

        return userDto;
    }
}
