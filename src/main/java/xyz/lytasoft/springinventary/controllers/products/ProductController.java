package xyz.lytasoft.springinventary.controllers.products;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xyz.lytasoft.springinventary.dto.MensajeDTO;
import xyz.lytasoft.springinventary.dto.ProductDTO;
import xyz.lytasoft.springinventary.models.products.ProductEntity;
import xyz.lytasoft.springinventary.services.products.CategoryService;
import xyz.lytasoft.springinventary.services.products.ProductService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/product/info")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<MensajeDTO> createProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult){

        MensajeDTO mensajeDTO;

        if(bindingResult.hasErrors()){
            mensajeDTO = MensajeDTO
                    .builder()
                    .message(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage())
                    .response(null)
                    .build();
            return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.BAD_REQUEST);
        }

        if (productService.existsProductByName(productDTO.getName())){
            mensajeDTO = MensajeDTO
                    .builder()
                    .message("Producto " + productDTO.getName() + " ya existe.")
                    .response(null)
                    .build();
            return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.BAD_REQUEST);
        }

        ProductEntity productEntity = ProductEntity
                .builder()
                .name(productDTO.getName())
                .details(productDTO.getDetails())
                .status(productDTO.getStatus())
                .category(productDTO.getCategory())
                .presentation(productDTO.getPresentation())
                .created_at(LocalDateTime.now())
                .build();

        mensajeDTO = MensajeDTO
                .builder()
                .message("¡Nuevo producto creado!")
                .response(productService.saveProduct(productEntity))
                .build();

        return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("list")
    public ResponseEntity<MensajeDTO> getAllCategories(){

        MensajeDTO mensajeDTO;
        List<ProductEntity> categories = productService.getAllProducts();

        mensajeDTO = MensajeDTO.builder()
                .response(categories)
                .message("Lista de presentaciones")
                .build();


        return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.OK);
    }

}
