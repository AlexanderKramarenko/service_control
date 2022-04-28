package ru.alexander_kramarenko.service_control_system.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexander_kramarenko.service_control_system.model.UserRole;
import ru.alexander_kramarenko.service_control_system.repositories.UserRoleRepository;


@Service
@RequiredArgsConstructor
public class UserRoleService {

    public final UserRoleRepository userRoleRepository;

    public UserRole save(UserRole userRoles) {
        return userRoleRepository.save(userRoles);
    }

}
