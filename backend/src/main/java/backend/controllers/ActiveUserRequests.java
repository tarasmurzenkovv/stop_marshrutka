package backend.controllers;

import lombok.Data;

@Data
public class ActiveUserRequests {
    private final String userName;
    private final Double latitudeStart;
    private final Double longitudeStart;
    private final Double latitudeEnd;
    private final Double longitudeEnd;
}
