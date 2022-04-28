package ru.alexander_kramarenko.service_control_system.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alexander_kramarenko.service_control_system.model.Brand;


@Data
@NoArgsConstructor
public class BrandDto {

    private Long id;
    private String name;

    public BrandDto(Brand brand) {
        this.id = brand.getId();
        this.name = brand.getName();
    }
}