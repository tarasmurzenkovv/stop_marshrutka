package backend.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DriverDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long driverId;

    @JsonUnwrapped
    private UserInformationDto userInformationDto;

    @JsonProperty("routes")
    private List<RouteDto> routeDtoList;

    @JsonProperty("cars")
    private List<CarDto> carDtoList;
}
