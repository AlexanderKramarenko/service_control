package ru.alexander_kramarenko.service_control_system.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alexander_kramarenko.service_control_system.model.Model;

@Data
@NoArgsConstructor
public class ModelDto {

        private Long id;
        private String category;
        private String brand;
        private String name;

    public ModelDto(Model model) {
        this.id = model.getId();
        this.category = model.getCategory().getName();
        this.brand =model.getBrand().getName();
        this.name = model.getName();
    }

    public ModelDto(Long id, String category, String brand, String name) {
        this.id = id;
        this.category = category;
        this.brand = brand;
        this.name = name;
    }
}
