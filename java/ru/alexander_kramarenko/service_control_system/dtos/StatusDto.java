package ru.alexander_kramarenko.service_control_system.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.alexander_kramarenko.service_control_system.model.Status;


@Data
@NoArgsConstructor
public class StatusDto {

    private Long id;
    private String name;

    public StatusDto(Status status) {
        this.id = status.getId();
        this.name = status.getName();
    }
}
