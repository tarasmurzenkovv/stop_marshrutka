package com.stop_marshrutka.backend.service;

import com.stop_marshrutka.backend.model.dto.RouteDto;
import com.stop_marshrutka.backend.model.entities.UserEntity;
import com.stop_marshrutka.backend.model.entities.RouteEntity;
import org.springframework.stereotype.Service;

@Service
public class RouteMapper {
    public RouteEntity toEntity(RouteDto routeDto, UserEntity userEntity) {
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setName(routeDto.getName());
        routeEntity.setStartLat(routeDto.getStartLat());
        routeEntity.setStartLog(routeDto.getStartLog());
        routeEntity.setEndLat(routeDto.getEndLat());
        routeEntity.setEndtLog(routeDto.getEndLog());
        routeEntity.setUserEntity(userEntity);
        return routeEntity;
    }

    public RouteDto toDto(RouteEntity routeEntity) {
        RouteDto routeDto = new RouteDto();

        routeDto.setId(routeEntity.getId());
        routeDto.setEndLat(routeEntity.getEndLat());
        routeDto.setEndLog(routeEntity.getEndtLog());
        routeDto.setStartLat(routeEntity.getStartLat());
        routeDto.setStartLog(routeEntity.getStartLog());
        routeDto.setName(routeEntity.getName());
        return routeDto;
    }
}
