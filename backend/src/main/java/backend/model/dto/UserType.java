package backend.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UserType {
    DRIVER("Driver"), PASSENGER("Passenger");

    private final String type;

    UserType(String customer) {
        this.type = customer;
    }

    @JsonCreator
    public static UserType fromValue(String enumAsString) {
        return Arrays.stream(UserType.values())
                .filter(value -> value.type.equalsIgnoreCase(enumAsString))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cannot find user type for string value" + enumAsString));
    }
}
