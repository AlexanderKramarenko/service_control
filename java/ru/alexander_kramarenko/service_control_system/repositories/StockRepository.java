package ru.alexander_kramarenko.service_control_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexander_kramarenko.service_control_system.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {


}
