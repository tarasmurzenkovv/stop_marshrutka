package com.stop_marshrutka.backend.controllers;

import com.stop_marshrutka.backend.model.dto.UserDto;
import com.stop_marshrutka.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v0", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/user")
    public Long registerUser(@RequestBody final UserDto userDto) {
        return userService.registerUser(userDto);
    }

    @GetMapping(value = "/user/{id}")
    public UserDto findUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}
