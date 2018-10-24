package backend.service;

import backend.model.dto.CarDto;
import backend.model.dto.DriverDto;
import backend.model.dto.RouteDto;
import backend.model.entities.CarEntity;
import backend.model.entities.UserEntity;
import backend.model.entities.RouteEntity;
import backend.repositories.UserRepository;
import backend.service.mappers.CarMapper;
import backend.service.mappers.DriverMapper;
import backend.service.mappers.RouteMapper;

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
