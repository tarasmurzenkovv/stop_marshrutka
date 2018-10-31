package backend.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PassengersSearchRequest {
    private final List<Point> route;
}
