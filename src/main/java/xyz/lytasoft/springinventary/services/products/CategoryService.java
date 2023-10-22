package xyz.lytasoft.springinventary.services.products;

import xyz.lytasoft.springinventary.models.products.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CategoryEntity saveCategory(CategoryEntity categoryEntity);

    void deleteCategory(Long id);

    List<CategoryEntity> getAllCategories();

    Optional<CategoryEntity> getCategoryByName(String name);

    Optional<CategoryEntity> getCategoryById(Long id);

    boolean existsCategoryByName(String name);

    boolean existsCategoryById(Long id);
}
