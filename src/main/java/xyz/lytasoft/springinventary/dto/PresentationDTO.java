package xyz.lytasoft.springinventary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PresentationDTO {

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
