package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImplemented implements CategorieService {
    private CategorieRepository repo;

    @Autowired
    public CategorieServiceImplemented(CategorieRepository repository) {
        repo = repository;
    }

    @Override
    public List<CategorieEntity> findAll() {
        return (List<CategorieEntity>) repo.findAll();
    }

    @Override
    public void desactiverCategorie(Integer idCategorie) {
        repo.findById(idCategorie).get().setActiveCategorie(false);
    }

    @Override
    public void activerCategorie(Integer idCategorie) {
        repo.findById(idCategorie).get().setActiveCategorie(true);
    }

    @Override
    public void ajouterCategorie(CategorieEntity nouvelleCategorie) {
        repo.save(nouvelleCategorie);
    }


}
