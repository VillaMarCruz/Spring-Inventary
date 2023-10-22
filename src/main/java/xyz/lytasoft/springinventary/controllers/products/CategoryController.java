package xyz.lytasoft.springinventary.controllers.products;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xyz.lytasoft.springinventary.dto.CategoryDTO;
import xyz.lytasoft.springinventary.dto.MensajeDTO;
import xyz.lytasoft.springinventary.models.products.CategoryEntity;
import xyz.lytasoft.springinventary.services.products.CategoryService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/product/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<MensajeDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult bindingResult){

        MensajeDTO mensajeDTO;

        if(bindingResult.hasErrors()){
            mensajeDTO = MensajeDTO
                    .builder()
                    .message(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage())
                    .response(null)
                    .build();
            return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.BAD_REQUEST);
        }

        if (categoryService.existsCategoryByName(categoryDTO.getName())){
            mensajeDTO = MensajeDTO
                    .builder()
                    .message("Categoría " + categoryDTO.getName() + " ya existe.")
                    .response(null)
                    .build();
            return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.BAD_REQUEST);
        }

        CategoryEntity categoryEntity = CategoryEntity
                .builder()
                .name(categoryDTO.getName())
                .description(categoryDTO.getDescription())
                .status(categoryDTO.getStatus())
                .created_at(LocalDateTime.now())
                .build();

        mensajeDTO = MensajeDTO
                .builder()
                .message("¡Nueva categoría creada!")
                .response(categoryService.saveCategory(categoryEntity))
                .build();

        return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("list")
    public ResponseEntity<MensajeDTO> getAllCategories(){

        MensajeDTO mensajeDTO;
        List<CategoryEntity> categories = categoryService.getAllCategories();

        mensajeDTO = MensajeDTO.builder()
                .response(categories)
                .message("Lista de categorías")
                .build();


        return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.OK);
    }


}
