package com.stop_marshrutka.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RouteDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String name;

    private Double startLat;

    private Double startLog;

    private Double endLat;

    private Double endLog;
}
