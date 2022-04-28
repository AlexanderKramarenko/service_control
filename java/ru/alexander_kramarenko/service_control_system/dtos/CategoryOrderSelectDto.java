package ru.alexander_kramarenko.service_control_system.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alexander_kramarenko.service_control_system.model.Category;


@Data
@NoArgsConstructor
public class CategoryOrderSelectDto {

    private Long id;
    private String name;


    public CategoryOrderSelectDto(Category categories) {
        this.id = categories.getId();
        this.name = categories.getName();

    }
}
