package com.stop_marshrutka.backend.service;

import com.stop_marshrutka.backend.model.dto.UserDto;
import com.stop_marshrutka.backend.model.entities.RouteEntity;
import com.stop_marshrutka.backend.model.entities.UserEntity;
import com.stop_marshrutka.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final RouteMapper routeMapper;
    private final UserRepository userRepository;

    @Transactional
    public Long registerUser(final UserDto userDto) {
        final UserEntity userEntity = userMapper.toUserEntity(userDto);
        if (!CollectionUtils.isEmpty(userDto.getRouteDtoList())) {
            final List<RouteEntity> routeEntities = userDto.getRouteDtoList()
                    .stream()
                    .map(routeDto -> routeMapper.toEntity(routeDto, userEntity))
                    .collect(Collectors.toList());
            userEntity.setRouteEntities(routeEntities);
        }
        return userRepository.save(userEntity).getId();
    }

    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toUserDto)
                .orElseThrow(() -> new RuntimeException("Cannot find user for id" + id));
    }
}
