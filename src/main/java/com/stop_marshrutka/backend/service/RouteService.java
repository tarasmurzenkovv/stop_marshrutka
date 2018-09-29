package com.stop_marshrutka.backend.service;

import com.stop_marshrutka.backend.model.dto.RouteDto;
import com.stop_marshrutka.backend.repositories.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteMapper routeMapper;
    private final RouteRepository routeRepository;

    public List<RouteDto> findAllRoutesForUserId(Long userId) {
        return routeRepository.findAllRoutesForUserId(userId)
                .stream()
                .map(routeMapper::toDto)
                .collect(Collectors.toList());
    }
}
