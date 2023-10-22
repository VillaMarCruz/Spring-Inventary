package xyz.lytasoft.springinventary.services.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.lytasoft.springinventary.models.products.PresentationEntity;
import xyz.lytasoft.springinventary.repositories.products.PresentationRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PresentationServiceImpl implements PresentationService {

    @Autowired
    private PresentationRepository presentationRepository;

    @Override
    public PresentationEntity savePresentation(PresentationEntity presentationEntity){
        return presentationRepository.save(presentationEntity);
    }

    @Override
    public void deletePresentation(Long id){
        presentationRepository.deleteById(id);
    }

    @Override
    public List<PresentationEntity> getAllPresentations(){
        return presentationRepository.findAll();
    }

    @Override
    public Optional<PresentationEntity> getPresentationByName(String name){
        return presentationRepository.findByName(name);
    }

    @Override
    public Optional<PresentationEntity> getPresentationById(Long id){
        return presentationRepository.findById(id);
    }

    @Override
    public boolean existsPresentationByName(String name){
        return presentationRepository.existsByName(name);
    }

    @Override
    public boolean existsPresentationById(Long id){
        return presentationRepository.existsById(id);
    }
    
}
