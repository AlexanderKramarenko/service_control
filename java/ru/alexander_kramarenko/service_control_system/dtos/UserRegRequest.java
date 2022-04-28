package ru.alexander_kramarenko.service_control_system.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alexander_kramarenko.service_control_system.model.User;


@NoArgsConstructor
@Data
public class UserRegRequest {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String middleNames;
    private String email;
    private String phone;

    public UserRegRequest(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.middleNames = user.getMiddleNames();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }
}
