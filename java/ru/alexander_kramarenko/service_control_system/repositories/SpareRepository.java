package ru.alexander_kramarenko.service_control_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexander_kramarenko.service_control_system.model.Spare;

@Repository
public interface SpareRepository extends JpaRepository<Spare, Long> {


}
