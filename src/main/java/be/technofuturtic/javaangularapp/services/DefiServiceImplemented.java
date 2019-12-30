package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import be.technofuturtic.javaangularapp.repositories.DefiRepository;
import be.technofuturtic.javaangularapp.utilitaires.DefiEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DefiServiceImplemented implements DefiService {
    private DefiRepository repo;
    private CategorieRepository repoCat;

    @Autowired
    public DefiServiceImplemented(DefiRepository repository, CategorieRepository repoCate) {
        repo = repository;
        repoCat = repoCate;
    }

    @Override
    public List<DefiEntity> findAll() {
        return (List<DefiEntity>) repo.findAll();
    }

    @Override
    public void desactiverDefi(Integer idDefi) {
        DefiEntity d = repo.findById(idDefi).get();
        d.setActiveDefi(false);
        repo.save(d);
    }

    @Override
    public void activerDefi(Integer idDefi) {
        DefiEntity d = repo.findById(idDefi).get();
        d.setActiveDefi(true);
        repo.save(d);
    }

    @Override
    public Boolean creerDefi(DefiEntityDto nouveauDefi) {
        Boolean isDuplicate = isDuplicate(nouveauDefi);
        if(!isDuplicate) {
            //Optional<CategorieEntity> categorieEntityOptional = this.repoCat.findById(nouveauDefi.getCategorieId());
            CategorieEntity categorieEntityOptional = this.repoCat.findCategorieEntityByNomCategorie(nouveauDefi.getNomCategorie());
            DefiEntity defiEntity = new DefiEntity(
                    nouveauDefi.getNomDefi(),
                    nouveauDefi.getDescDefi(),
                    nouveauDefi.getInfobulleDefi(),
                    categorieEntityOptional
            );
            defiEntity.setActiveDefi(true);
            this.repo.save(defiEntity);
        }
        return isDuplicate;
    }

    private Boolean isDuplicate(DefiEntityDto defi) {
        boolean isDuplicate = false;
        List<DefiEntity> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (defi.getNomDefi().equals(all.get(i).getNomDefi())) {
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }

    @Override
    public List<DefiEntity> listerActifs() {
        List<DefiEntity> l = findAll();
        List<DefiEntity> a = new ArrayList<>();
        for (int i = 0; i < findAll().size(); i++) {
            if(findAll().get(i).isActiveDefi()) {
                a.add(l.get(i));
            }
        }
        return a;
    }

    @Override
    public Boolean majDefi(Integer idDefi, DefiEntityDto updateDefi) {
        Boolean isDuplicate = isDuplicate(updateDefi);
        if (!isDuplicate) {
            DefiEntity defiAModifier = repo.findByIdDefi(idDefi);
            defiAModifier.setNomDefi(updateDefi.getNomDefi());
            defiAModifier.setDescDefi(updateDefi.getDescDefi());
            defiAModifier.setInfobulleDefi(updateDefi.getInfobulleDefi());
            CategorieEntity c = repoCat.findById(updateDefi.getCategorieId()).get();
            defiAModifier.setCategorie(c);
            repo.save(defiAModifier);
        }
       return isDuplicate;
    }

    @Override
    public Integer getIdCategorie(Integer idDefi) {
        DefiEntity d = repo.findById(idDefi).get();
        return d.getCategorie().getIdCategorie();
    }
}
