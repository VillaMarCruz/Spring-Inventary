package xyz.lytasoft.springinventary.services.products;

import xyz.lytasoft.springinventary.models.products.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductEntity saveProduct(ProductEntity productEntity);

    void deleteProduct(Long id);

    List<ProductEntity> getAllProducts();

    Optional<ProductEntity> getProductByName(String name);

    Optional<ProductEntity> getProductById(Long id);

    boolean existsProductByName(String name);

    boolean existsProductById(Long id);
}
