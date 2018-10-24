package backend.service.mappers;

import backend.model.dto.*;
import backend.model.entities.UserEntity;
import backend.model.entities.UserInformation;
import backend.repositories.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMapper {
    private final UserTypeRepository userTypeRepository;
    private final CarMapper carMapper;
    private final RouteMapper routeMapper;
    private final UserInformationMapper userInformationMapper;

    public UserEntity toDriverEntity(DriverDto driverDto) {
        UserEntity userEntity = new UserEntity();

        UserInformationDto userInformationDto = driverDto.getUserInformationDto();
        UserInformation userInformation = userInformationMapper.toUserInformation(userInformationDto);

        userEntity.setUserInformation(userInformation);
        userEntity.setUserTypeEntity(userTypeRepository.getDriverType());

        return userEntity;
    }

    public DriverDto toUserDto(UserEntity userEntity) {
        DriverDto driverDto = new DriverDto();
        UserInformation userInformation = userEntity.getUserInformation();
        List<RouteDto> routeDtoList = routeMapper.toDtos(userEntity.getRouteEntities());
        List<CarDto> carDtoList = carMapper.toCarDtos(userEntity.getCarEntities());
        UserInformationDto userInformationDto = userInformationMapper.toUserInformationDto(userInformation);

        driverDto.setDriverId(userEntity.getId());
        driverDto.setCarDtoList(carDtoList);
        driverDto.setRouteDtoList(routeDtoList);
        driverDto.setUserInformationDto(userInformationDto);

        return driverDto;
    }
}
