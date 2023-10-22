package xyz.lytasoft.springinventary.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryDTO {

    @NotBlank(message = "El campo nombre no debe estar en blanco.")
    @NotEmpty(message = "El campo nombre no debe estar vacío.")
    @NotNull(message = "El campo nombre no debe ser null.")
    @Size(min = 0, max = 100)
    private String name;

    @NotBlank(message = "El campo nombre no debe estar en blanco.")
    @NotEmpty(message = "El campo nombre no debe estar vacío.")
    @NotNull(message = "El campo nombre no debe ser null.")
    @Size(min = 0, max = 250)
    private String description;

    private int status;

}
