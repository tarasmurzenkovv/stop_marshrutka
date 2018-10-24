package backend.service.mappers;

import backend.model.dto.PassengerDto;
import backend.model.dto.RouteDto;
import backend.model.dto.UserInformationDto;
import backend.model.entities.UserEntity;
import backend.repositories.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerMapper {
    private final RouteMapper routeMapper;
    private final UserInformationMapper userInformationMapper;
    private final UserTypeRepository userTypeRepository;

    public UserEntity toUserEntity(PassengerDto passengerDto) {
        UserEntity userEntity = new UserEntity();

        UserInformationDto userInformationDto = passengerDto.getUserInformationDto();
        List<RouteDto> routeDtoList = passengerDto.getRouteDtoList();

        userEntity.setRouteEntities(routeMapper.toEntities(routeDtoList, userEntity));
        userEntity.setUserTypeEntity(userTypeRepository.getPassengerType());
        userEntity.setUserInformation(userInformationMapper.toUserInformation(userInformationDto));

        return userEntity;
    }

    public PassengerDto toPassengerDto(UserEntity userEntity) {
        PassengerDto passengerDto = new PassengerDto();

        List<RouteDto> routeDtos = routeMapper.toDtos(userEntity.getRouteEntities());
        UserInformationDto userInformationDto = userInformationMapper.toUserInformationDto(userEntity.getUserInformation());

        passengerDto.setPassengerId(userEntity.getId());
        passengerDto.setRouteDtoList(routeDtos);
        passengerDto.setUserInformationDto(userInformationDto);

        return passengerDto;
    }
}
