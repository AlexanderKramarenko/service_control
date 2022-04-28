package ru.alexander_kramarenko.service_control_system.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.alexander_kramarenko.service_control_system.model.Category;
import ru.alexander_kramarenko.service_control_system.repositories.CategoryRepository;


import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {

    public final CategoryRepository categoryRepository;

    public Page<Category> findAllCategories(int pageIndex, int pageSize) {
        return categoryRepository.findAllCategories(PageRequest.of(pageIndex, pageSize));
    }

    public List<Category> findAllCategoriesForOrderPage() {
        return categoryRepository.findAllCategoriesForOrderPage();
    }


}
