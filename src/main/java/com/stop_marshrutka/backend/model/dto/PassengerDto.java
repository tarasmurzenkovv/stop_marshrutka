package com.stop_marshrutka.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PassengerDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long passengerId;

    @JsonUnwrapped
    private UserInformationDto userInformationDto;

    @JsonProperty("routes")
    private List<RouteDto> routeDtoList;
}
