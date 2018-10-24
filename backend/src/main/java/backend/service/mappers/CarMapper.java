package backend.service.mappers;

import backend.model.dto.CarDto;
import backend.model.entities.CarEntity;
import backend.model.entities.UserEntity;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarMapper {

    public List<CarEntity> toCarEntities(List<CarDto> carDtos, UserEntity userEntity) {
        return carDtos.stream()
                .map(carDto -> toCarEntity(carDto, userEntity))
                .collect(Collectors.toList());
    }

    public List<CarDto> toCarDtos(List<CarEntity> carEntities) {
        return carEntities.stream()
                .map(this::toCarDto)
                .collect(Collectors.toList());
    }

    public CarEntity toCarEntity(CarDto carDto, UserEntity userEntity) {
        CarEntity carEntity = new CarEntity();

        carEntity.setCarNumber(carDto.getCarNumber());
        carEntity.setCarType(carDto.getCarType());
        carEntity.setUserEntity(userEntity);

        return carEntity;
    }

    public CarDto toCarDto(CarEntity carEntity) {
        CarDto carDto = new CarDto();

        carDto.setCarId(carEntity.getId());
        carDto.setCarNumber(carEntity.getCarNumber());
        carDto.setCarType(carEntity.getCarType());

        return carDto;
    }
}
