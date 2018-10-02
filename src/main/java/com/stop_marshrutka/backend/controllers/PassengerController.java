package com.stop_marshrutka.backend.controllers;

import com.stop_marshrutka.backend.model.dto.PassengerDto;
import com.stop_marshrutka.backend.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v0", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping(value = "/passenger")
    public Long register(@RequestBody final PassengerDto passengerDto) {
        return passengerService.register(passengerDto);
    }

    @GetMapping(value = "/passenger/{id}")
    public PassengerDto find(@PathVariable("id") Long id) {
        return passengerService.findById(id);
    }
}
