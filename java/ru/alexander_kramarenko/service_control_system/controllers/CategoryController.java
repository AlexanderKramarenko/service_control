package ru.alexander_kramarenko.service_control_system.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alexander_kramarenko.service_control_system.dtos.CategoryDto;
import ru.alexander_kramarenko.service_control_system.dtos.CategoryOrderSelectDto;
import ru.alexander_kramarenko.service_control_system.services.CategoryService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

   private final CategoryService categoryService;

    @GetMapping("/all_categories")
    public Page<CategoryDto> findAllCategories(@RequestParam(defaultValue = "1", name = "p") int pageIndex){
        if (pageIndex < 1) {
            pageIndex = 1;
        }

        return categoryService.findAllCategories(pageIndex - 1, 50).map(CategoryDto::new);
    }

    @GetMapping("/all_categories_for_order_page")
    public List<CategoryOrderSelectDto> findAllCategoriesForOrderPage(){

        return categoryService.findAllCategoriesForOrderPage().stream().map(CategoryOrderSelectDto::new).collect(Collectors.toList());
    }


}