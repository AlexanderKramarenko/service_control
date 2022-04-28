package ru.alexander_kramarenko.service_control_system.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.alexander_kramarenko.service_control_system.model.Brand;
import ru.alexander_kramarenko.service_control_system.model.Model;


import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query(
            value = "SELECT * " +
                    "FROM brands " +
                    "ORDER BY id DESC ",
            countQuery = "SELECT count(*) FROM brands ",
            nativeQuery = true)
    Page<Brand> findAllBrandsPageable(Pageable pageable);


    // 1st option - category, brand, model selected separately

    @Query(
            value = "SELECT * " +
                    "FROM brands " +
                    "ORDER BY id DESC ",
            nativeQuery = true)
    List<Brand> findAllBrandsForOrderPage();

    @Query(
            value = "SELECT * " +
                    "FROM models " +
                    "WHERE category_id = :selectedCategoryId ",

            nativeQuery = true)
    List<Model> findBrandsBySelectedCategory(Long selectedCategoryId);

}
