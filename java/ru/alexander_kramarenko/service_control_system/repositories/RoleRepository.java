package ru.alexander_kramarenko.service_control_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.alexander_kramarenko.service_control_system.model.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    @Query("select c from Role c where c.name = :name")
    Optional<Role> findByRoleName(String name);


}
