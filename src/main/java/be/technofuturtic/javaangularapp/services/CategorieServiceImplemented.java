package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        CategorieEntity c = repo.findById(idCategorie).get();
        c.setActiveCategorie(false);
        repo.save(c);
    }

    @Override
    public void activerCategorie(Integer idCategorie) {
        CategorieEntity c = repo.findById(idCategorie).get();
        c.setActiveCategorie(true);
        repo.save(c);
    }

    // test : http://localhost:8080/api/categories/activer/69 -> pas de body

    private boolean isDuplicate(CategorieEntity categorie) {
        boolean isDuplicate = false;
        List<CategorieEntity> categoriesExistantes = findAll();
        for (int i = 0; i < categoriesExistantes.size(); i++) {
            if (categorie.getNomCategorie().equals(categoriesExistantes.get(i).getNomCategorie())) {
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }

    @Override
    public void ajouterCategorie(CategorieEntity nouvelleCategorie) {
        if (!isDuplicate(nouvelleCategorie)) {
            repo.save(nouvelleCategorie);
        }
    }

    @Override
    public void majCategorie(Integer idCategorie, CategorieEntity categorie) {
        CategorieEntity c = repo.findById(idCategorie).get();
        if(!isDuplicate(categorie)) {
            c.setNomCategorie(categorie.getNomCategorie());
            c.setDescCategorie(categorie.getDescCategorie());
            repo.save(c);
        }
    }


}
