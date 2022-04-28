package ru.alexander_kramarenko.service_control_system.utils;


import org.springframework.stereotype.Component;
import ru.alexander_kramarenko.service_control_system.dtos.ModelDto;
import ru.alexander_kramarenko.service_control_system.model.Model;


@Component
public class Converter {

    public ModelDto modelToDto(Model model) {
        return new ModelDto(model.getId(),
                model.getCategory().getDescription(),
                model.getBrand().getName(),
                model.getName()
);
    }


}
