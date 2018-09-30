package com.stop_marshrutka.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long userId;
    private String userName;
    private UserType userType;
    @JsonProperty("routes")
    private List<RouteDto> routeDtoList;
}
