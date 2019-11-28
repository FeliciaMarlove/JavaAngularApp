package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.repositories.*;
import be.technofuturtic.javaangularapp.utilitaires.DefiEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParcoursServiceImplemented implements ParcoursService {
    private ParcoursRepository repo;
    private DefiRepository repoDefi;
    private CategorieRepository repoCat;

    @Autowired
    public ParcoursServiceImplemented(ParcoursRepository repository, DefiRepository defiRepository, CategorieRepository repoCat) {
       repo = repository;
       repoDefi = defiRepository;
        this.repoCat = repoCat;
    }

    @Override
    public List<ParcoursEntity> findAll() {
        return (List<ParcoursEntity>) repo.findAll();
    }

    @Override
    public void desactiverParcours(Integer idParcours) {
        repo.findById(idParcours).get().setActiveParcours(false);
    }

    @Override
    public void activerParcours(Integer idParcours) {
        repo.findById(idParcours).get().setActiveParcours(true);
    }

    @Override
    public void ajouterParcours(ParcoursEntity nouveauParcours) {
        repo.save(nouveauParcours);
    }

    @Override
    public void ajouterDefiDansParcours(Integer idParcours, DefiEntityDto nouveauDefi) throws Exception {
        Optional<ParcoursEntity> parcoursEntity = this.repo.findById(idParcours);
        if (parcoursEntity.isEmpty())throw new Exception();
        ParcoursEntity parcours = parcoursEntity.get();
        Optional<CategorieEntity> categorieEntityOptional = this.repoCat.findById(nouveauDefi.getCategorieId());
        DefiEntity defiEntity = new DefiEntity(
                nouveauDefi.getNomDefi(),
                nouveauDefi.getDescDefi(),
                nouveauDefi.getInfobulleDefi(),
                categorieEntityOptional
        );
        this.repoDefi.save(defiEntity);
        parcours.getListeDefis().add(defiEntity);
        repo.save(parcours);
    }

    @Override
    public void modifierDefiDansParcours(Integer idParcours, Integer idDefiARemplacer, DefiEntity nouveauDefi) {
        Optional<ParcoursEntity> parcoursModif = repo.findById(idParcours);
        List<DefiEntity> listeDefis = new ArrayList();
        listeDefis.addAll(parcoursModif.get().getListeDefis());// liste de DefiEntity du Parcours
        int indice = 0;
        for (int i = 0; i < listeDefis.size(); i++) {
            if (listeDefis.get(i).getIdDefi() == idDefiARemplacer) { //est-ce que l'id à remplacer est bien présent dans la liste
                indice = i;
            }
        }
        this.repoDefi.save(nouveauDefi);
        ParcoursEntity p = parcoursModif.get();
        p.getListeDefis().remove(p.getListeDefis().get(indice));
        repo.save(p);
        p.getListeDefis().add(nouveauDefi);
        repo.save(p);
    }

    @Override
    public void supprimerDefiDansParcours(Integer idParcours, Integer idDefiASupprimer) {
        boolean checker = false;
        Optional<ParcoursEntity> parcoursModif = repo.findById(idParcours);
        List<DefiEntity> listeDefis = new ArrayList();
        int indice = -1;
        listeDefis.addAll(parcoursModif.get().getListeDefis());
        for (int i = 0; i < listeDefis.size(); i++) {
            if (listeDefis.get(i).getIdDefi() == idDefiASupprimer) {
                checker = true;
                indice = i;
            }
        }
        ParcoursEntity p = parcoursModif.get();
        if (indice >=0) p.getListeDefis().remove(indice);
        repo.save(p);
    }

//-------------------laboratoire expérimental :


}
