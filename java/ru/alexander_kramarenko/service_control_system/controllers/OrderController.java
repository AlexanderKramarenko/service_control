package ru.alexander_kramarenko.service_control_system.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexander_kramarenko.service_control_system.dtos.ModelDto;

import ru.alexander_kramarenko.service_control_system.services.ModelService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final ModelService modelService;

    @GetMapping("/order_page_data")
    public List<ModelDto> findAllModelsForOrderPage() {
        return modelService.findAllModelsForOrderPage().stream().map(ModelDto::new).collect(Collectors.toList());
    }


}


