package ru.alexander_kramarenko.service_control_system.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthRequest {

    private String login;
    private String password;

}