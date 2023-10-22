package xyz.lytasoft.springinventary.services.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.lytasoft.springinventary.models.products.CategoryEntity;
import xyz.lytasoft.springinventary.repositories.products.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity saveCategory(CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryEntity> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public Optional<CategoryEntity> getCategoryByName(String name){
        return categoryRepository.findByName(name);
    }

    @Override
    public Optional<CategoryEntity> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }

    @Override
    public boolean existsCategoryByName(String name){
        return categoryRepository.existsByName(name);
    }

    @Override
    public boolean existsCategoryById(Long id){
        return categoryRepository.existsById(id);
    }

}
