package com.stop_marshrutka.backend.service.mappers;

import com.stop_marshrutka.backend.model.dto.PassengerDto;
import com.stop_marshrutka.backend.model.dto.RouteDto;
import com.stop_marshrutka.backend.model.dto.UserInformationDto;
import com.stop_marshrutka.backend.model.entities.UserEntity;
import com.stop_marshrutka.backend.repositories.UserTypeRepository;
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
