package backend.service.mappers;

import backend.model.dto.RouteDto;
import backend.model.entities.UserEntity;
import backend.model.entities.RouteEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteMapper {

    public List<RouteEntity> toEntities(List<RouteDto> routeDtos, UserEntity userEntity) {
        return routeDtos.stream()
                .map(routeDto -> toEntity(routeDto, userEntity))
                .collect(Collectors.toList());
    }

    public List<RouteDto> toDtos(List<RouteEntity> routeEntities) {
        return routeEntities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

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
