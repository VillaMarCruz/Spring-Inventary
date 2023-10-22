package xyz.lytasoft.springinventary.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import xyz.lytasoft.springinventary.models.products.CategoryEntity;
import xyz.lytasoft.springinventary.models.products.PresentationEntity;

import java.time.LocalDateTime;

@Data
public class ProductDTO {

    @NotBlank(message = "El campo nombre no debe estar en blanco.")
    @NotEmpty(message = "El campo nombre no debe estar vacío.")
    @NotNull(message = "El campo nombre no debe ser null.")
    private String name;

    @NotBlank(message = "El campo nombre no debe estar en blanco.")
    @NotEmpty(message = "El campo nombre no debe estar vacío.")
    @NotNull(message = "El campo nombre no debe ser null.")
    private String details;

    private int status;

    private CategoryEntity category;

    private PresentationEntity presentation;

}
