package xyz.lytasoft.springinventary.services.products;

import xyz.lytasoft.springinventary.models.products.PresentationEntity;

import java.util.List;
import java.util.Optional;

public interface PresentationService {
    PresentationEntity savePresentation(PresentationEntity presentationEntity);

    void deletePresentation(Long id);

    List<PresentationEntity> getAllPresentations();

    Optional<PresentationEntity> getPresentationByName(String name);

    Optional<PresentationEntity> getPresentationById(Long id);

    boolean existsPresentationByName(String name);

    boolean existsPresentationById(Long id);
}
