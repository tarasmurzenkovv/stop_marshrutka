package com.stop_marshrutka.backend.service;

import com.stop_marshrutka.backend.model.dto.CarDto;
import com.stop_marshrutka.backend.model.dto.DriverDto;
import com.stop_marshrutka.backend.model.dto.RouteDto;
import com.stop_marshrutka.backend.model.entities.CarEntity;
import com.stop_marshrutka.backend.model.entities.UserEntity;
import com.stop_marshrutka.backend.model.entities.RouteEntity;
import com.stop_marshrutka.backend.repositories.UserRepository;
import com.stop_marshrutka.backend.service.mappers.CarMapper;
import com.stop_marshrutka.backend.service.mappers.DriverMapper;
import com.stop_marshrutka.backend.service.mappers.RouteMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverMapper driverMapper;
    private final RouteMapper routeMapper;
    private final CarMapper carMapper;
    private final UserRepository userRepository;

    @Transactional
    public Long registerDriver(final DriverDto driverDto) {
        final UserEntity userEntity = driverMapper.toDriverEntity(driverDto);
        final List<RouteDto> routeDtoList = driverDto.getRouteDtoList();
        final List<CarDto> carDtoList = driverDto.getCarDtoList();

        appendRoutes(userEntity, routeDtoList);
        appendCars(userEntity, carDtoList);

        return userRepository.save(userEntity).getId();
    }

    public DriverDto findById(Long id) {
        return userRepository.findById(id)
                .map(driverMapper::toUserDto)
                .orElseThrow(() -> new RuntimeException("Cannot find user for id" + id));
    }

    private void appendCars(UserEntity userEntity, List<CarDto> carDtoList) {
        if (!CollectionUtils.isEmpty(carDtoList)) {
            final List<CarEntity> carEntities = carMapper.toCarEntities(carDtoList, userEntity);
            userEntity.setCarEntities(carEntities);
        }
    }

    private void appendRoutes(UserEntity userEntity, List<RouteDto> routeDtoList) {
        if (!CollectionUtils.isEmpty(routeDtoList)) {
            final List<RouteEntity> routeEntities = routeMapper.toEntities(routeDtoList, userEntity);
            userEntity.setRouteEntities(routeEntities);
        }
    }
}
