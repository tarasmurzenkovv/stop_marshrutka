package backend.service;

import backend.model.dto.RouteDto;
import backend.repositories.RouteRepository;
import backend.service.mappers.RouteMapper;

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
