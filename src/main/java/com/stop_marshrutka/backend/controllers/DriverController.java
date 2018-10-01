package com.stop_marshrutka.backend.controllers;

import com.stop_marshrutka.backend.model.dto.UserDto;
import com.stop_marshrutka.backend.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v0", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {
    private final DriverService driverService;

    @PostMapping(value = "/driver")
    public Long register(@RequestBody final UserDto userDto) {
        return driverService.registerDriver(userDto);
    }

    @GetMapping(value = "/driver/{id}")
    public UserDto find(@PathVariable("id") Long id) {
        return driverService.findById(id);
    }
}
