package xyz.lytasoft.springinventary.repositories.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.lytasoft.springinventary.models.products.CategoryEntity;
import xyz.lytasoft.springinventary.models.products.PresentationEntity;
import xyz.lytasoft.springinventary.models.products.ProductEntity;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByName(String name);

    Optional<ProductEntity> findByCategory(CategoryEntity category);

    boolean existsByName(String name);

}
