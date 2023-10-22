package xyz.lytasoft.springinventary.services.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.lytasoft.springinventary.models.products.ProductEntity;
import xyz.lytasoft.springinventary.repositories.products.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

    @Override
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> getProductByName(String name){
        return productRepository.findByName(name);
    }

    @Override
    public Optional<ProductEntity> getProductById(Long id){
        return productRepository.findById(id);
    }

    @Override
    public boolean existsProductByName(String name){
        return productRepository.existsByName(name);
    }

    @Override
    public boolean existsProductById(Long id){
        return productRepository.existsById(id);
    }
    
}
