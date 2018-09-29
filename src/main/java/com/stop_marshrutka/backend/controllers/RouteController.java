package com.stop_marshrutka.backend.controllers;

import com.stop_marshrutka.backend.model.dto.RouteDto;
import com.stop_marshrutka.backend.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v0", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RouteController {
    private final RouteService routeService;

    @GetMapping("/route")
    public List<RouteDto> findAllUSerRoutes(@RequestParam("userId") Long userId) {
        return routeService.findAllRoutesForUserId(userId);
    }
}
