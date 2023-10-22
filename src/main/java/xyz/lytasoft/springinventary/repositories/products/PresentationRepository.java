package xyz.lytasoft.springinventary.repositories.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.lytasoft.springinventary.models.products.CategoryEntity;
import xyz.lytasoft.springinventary.models.products.PresentationEntity;

import java.util.Optional;

@Repository
public interface PresentationRepository extends JpaRepository<PresentationEntity, Long> {

    Optional<PresentationEntity> findByName(String name);

    boolean existsByName(String name);

}
