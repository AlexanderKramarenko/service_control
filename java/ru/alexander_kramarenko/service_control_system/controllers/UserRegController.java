package ru.alexander_kramarenko.service_control_system.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexander_kramarenko.service_control_system.dtos.UserRegRequest;
import ru.alexander_kramarenko.service_control_system.exceptions.DataValidationException;
import ru.alexander_kramarenko.service_control_system.model.User;
import ru.alexander_kramarenko.service_control_system.model.UserRole;
import ru.alexander_kramarenko.service_control_system.services.RoleService;
import ru.alexander_kramarenko.service_control_system.services.UserRoleService;
import ru.alexander_kramarenko.service_control_system.services.UserService;


import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reg_user")
@RequiredArgsConstructor
public class UserRegController {

    private final String INITIAL_USER_ROLE = "ROLE_USER";

    private final UserService userService;
    private final RoleService roleService;
    private final UserRoleService userRoleService;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    public UserRegRequest save(@RequestBody @Validated UserRegRequest userRegRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new DataValidationException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
        }
        User user = new User();
        user.setLogin(userRegRequest.getLogin());
        user.setFirstName(userRegRequest.getFirstName());
        user.setLastName(userRegRequest.getLastName());
        user.setMiddleNames(userRegRequest.getMiddleNames());
        user.setEmail(userRegRequest.getEmail());
        user.setPhone(userRegRequest.getPhone());
        user.setPassword(bCryptPasswordEncoder.encode(userRegRequest.getPassword()));
        userService.save(user);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(roleService.findByRoleName(INITIAL_USER_ROLE).stream().map(role -> role.getId()).collect(Collectors.toList()).get(0));
        userRoleService.save(userRole);

        return new UserRegRequest(user);
    }


}
