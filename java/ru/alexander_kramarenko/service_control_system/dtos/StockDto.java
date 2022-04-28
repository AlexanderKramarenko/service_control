package ru.alexander_kramarenko.service_control_system.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alexander_kramarenko.service_control_system.model.Spare;
import ru.alexander_kramarenko.service_control_system.model.Stock;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class StockDto {

    private Long id;
    private Spare spares;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StockDto(Stock stock) {
        this.id = stock.getId();
        this.spares = stock.getSpares();
        this.quantity = stock.getQuantity();
    }
}