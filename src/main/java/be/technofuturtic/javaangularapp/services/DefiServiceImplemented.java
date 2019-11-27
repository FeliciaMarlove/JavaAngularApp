package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.repositories.DefiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefiServiceImplemented implements DefiService {
    private DefiRepository repo;

    @Autowired
    public DefiServiceImplemented(DefiRepository repository) {
        repo = repository;
    }

    @Override
    public List<DefiEntity> findAll() {
        return (List<DefiEntity>) repo.findAll();
    }

    @Override
    public void desactiverDefi(Integer idDefi) {
        repo.findById(idDefi).get().setActiveDefi(false);
    }

    @Override
    public void activerDefi(Integer idDefi) {
        repo.findById(idDefi).get().setActiveDefi(true);
    }

    @Override
    public void creerDefi(DefiEntity nouveauDefi) {
        repo.save(nouveauDefi);
    }
}
