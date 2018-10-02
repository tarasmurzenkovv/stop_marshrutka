package com.stop_marshrutka.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long carId;

    private String carType;

    private String carNumber;
}
