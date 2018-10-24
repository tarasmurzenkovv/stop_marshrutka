package backend.service;

import backend.model.dto.PassengerDto;
import backend.model.entities.UserEntity;
import backend.repositories.UserRepository;
import backend.service.mappers.PassengerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerMapper passengerMapper;
    private final UserRepository userRepository;

    @Transactional
    public Long register(PassengerDto passengerDto) {
        UserEntity userEntity = passengerMapper.toUserEntity(passengerDto);
        return userRepository.save(userEntity).getId();
    }

    public PassengerDto findById(Long id) {
        return userRepository.findById(id)
                .map(passengerMapper::toPassengerDto)
                .orElseThrow(() -> new RuntimeException("Cannot find passenger for id " + id));
    }
}
