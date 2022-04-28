package ru.alexander_kramarenko.service_control_system.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexander_kramarenko.service_control_system.dtos.StatusDto;
import ru.alexander_kramarenko.service_control_system.dtos.UserDto;
import ru.alexander_kramarenko.service_control_system.services.StatusService;
import ru.alexander_kramarenko.service_control_system.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all_users_for_order_page")
    public List<UserDto> findAllUsersForOrderForm() {
        return userService.findAllUsersForOrderForm().stream().map(UserDto::new).collect(Collectors.toList());
    }




}
