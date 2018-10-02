package com.stop_marshrutka.backend.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class UserInformationDto {

    private String login;

    private String password;

    private String email;

    private String telephoneNumber;

    private String name;

    private String surname;
}
