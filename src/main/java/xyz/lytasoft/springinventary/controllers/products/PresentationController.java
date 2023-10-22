package xyz.lytasoft.springinventary.controllers.products;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xyz.lytasoft.springinventary.dto.PresentationDTO;
import xyz.lytasoft.springinventary.dto.MensajeDTO;
import xyz.lytasoft.springinventary.models.products.PresentationEntity;
import xyz.lytasoft.springinventary.services.products.CategoryService;
import xyz.lytasoft.springinventary.services.products.PresentationService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/product/presentation")
public class PresentationController {

    @Autowired
    private PresentationService presentationService;

    @PostMapping("/create")
    public ResponseEntity<MensajeDTO> createPresentation(@Valid @RequestBody PresentationDTO presentationDTO, BindingResult bindingResult){

        MensajeDTO mensajeDTO;

        if(bindingResult.hasErrors()){
            mensajeDTO = MensajeDTO
                    .builder()
                    .message(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage())
                    .response(null)
                    .build();
            return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.BAD_REQUEST);
        }

        if (presentationService.existsPresentationByName(presentationDTO.getName())){
            mensajeDTO = MensajeDTO
                    .builder()
                    .message("Categoría " + presentationDTO.getName() + " ya existe.")
                    .response(null)
                    .build();
            return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.BAD_REQUEST);
        }

        PresentationEntity presentationEntity = PresentationEntity
                .builder()
                .name(presentationDTO.getName())
                .description(presentationDTO.getDescription())
                .status(presentationDTO.getStatus())
                .created_at(LocalDateTime.now())
                .build();

        mensajeDTO = MensajeDTO
                .builder()
                .message("¡Nueva presentación creada!")
                .response(presentationService.savePresentation(presentationEntity))
                .build();

        return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("list")
    public ResponseEntity<MensajeDTO> getAllCategories(){

        MensajeDTO mensajeDTO;
        List<PresentationEntity> categories = presentationService.getAllPresentations();

        mensajeDTO = MensajeDTO.builder()
                .response(categories)
                .message("Lista de presentaciones")
                .build();


        return new ResponseEntity<MensajeDTO>(mensajeDTO, HttpStatus.OK);
    }
    
}
