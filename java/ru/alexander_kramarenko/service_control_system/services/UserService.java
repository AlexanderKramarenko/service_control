package ru.alexander_kramarenko.service_control_system.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexander_kramarenko.service_control_system.model.Role;
import ru.alexander_kramarenko.service_control_system.model.User;
import ru.alexander_kramarenko.service_control_system.repositories.UserRepository;
import ru.alexander_kramarenko.service_control_system.repositories.UserRoleRepository;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User users = findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", login)));
        return new org.springframework.security.core.userdetails.User(users.getLogin(), users.getPassword(), mapRolesToAuthorities(users.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public User save(User user) {
        return userRepository.save(user);
    }


    public List<User> findAllUsersForOrderForm(){
        return userRepository.findAllUsersForOrderForm();
    }

}