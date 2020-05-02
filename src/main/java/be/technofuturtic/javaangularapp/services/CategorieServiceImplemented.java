package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public Boolean ajouterCategorie(CategorieEntity nouvelleCategorie) {
        Boolean hasFailed = true;
        if (!isDuplicate(nouvelleCategorie)) {
            repo.save(nouvelleCategorie);
            hasFailed = false;
        }
        return hasFailed;
    }

    @Override
    public Boolean majCategorie(Integer idCategorie, CategorieEntity categorie) {
        CategorieEntity c = repo.findById(idCategorie).get();
        Boolean hasFailed = true;
        if(!isDuplicate(categorie)) {
            c.setNomCategorie(categorie.getNomCategorie());
            c.setDescCategorie(categorie.getDescCategorie());
            repo.save(c);
            hasFailed = false;
        }
        return hasFailed;
    }

    @Override
    public List<CategorieEntity> findAllActifs() {
        List<CategorieEntity> liste = (List<CategorieEntity>) repo.findAll();
        List<CategorieEntity> a = new ArrayList<CategorieEntity>();
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).isActiveCategorie()) {
                a.add(liste.get(i));
            }
        }
        return a;
    }
}
