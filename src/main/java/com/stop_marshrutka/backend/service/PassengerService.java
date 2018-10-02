package com.stop_marshrutka.backend.service;

import com.stop_marshrutka.backend.model.dto.PassengerDto;
import com.stop_marshrutka.backend.model.entities.UserEntity;
import com.stop_marshrutka.backend.repositories.UserRepository;
import com.stop_marshrutka.backend.service.mappers.PassengerMapper;
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
