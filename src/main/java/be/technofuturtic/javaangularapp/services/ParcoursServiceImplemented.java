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
        ParcoursEntity p = repo.findById(idParcours).get();
        p.setActiveParcours(false);
        repo.save(p);
    }

    @Override
    public void activerParcours(Integer idParcours) {
        ParcoursEntity p = repo.findById(idParcours).get();
        p.setActiveParcours(true);
        repo.save(p);
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
        defiEntity.setActiveDefi(true);
        this.repoDefi.save(defiEntity);
        parcours.getListeDefis().add(defiEntity);
        repo.save(parcours);
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

    public void modifierDefiDansParcours(Integer idParcours, Integer idDefiARemplacer, DefiEntityDto nouveauDefi) throws Exception {
        Optional<ParcoursEntity> parcoursEntity = this.repo.findById(idParcours);
        if (parcoursEntity.isEmpty())throw new Exception();
        ParcoursEntity parcours = parcoursEntity.get();
        Optional<CategorieEntity> categorieEntityOptional = this.repoCat.findById(nouveauDefi.getCategorieId());
        CategorieEntity cat = categorieEntityOptional.get();
        DefiEntity defiEntity = new DefiEntity(
                nouveauDefi.getNomDefi(),
                nouveauDefi.getDescDefi(),
                nouveauDefi.getInfobulleDefi(),
                cat
        );
        List<DefiEntity> listeDefis = new ArrayList();
        listeDefis.addAll(parcours.getListeDefis());
        int indice = 0;
        for (int i = 0; i < listeDefis.size(); i++) {
            if (listeDefis.get(i).getIdDefi() == idDefiARemplacer) { //est-ce que l'id à remplacer est bien présent dans la liste
                indice = i;
            }
        }
        this.repoDefi.save(defiEntity);
        parcours.getListeDefis().remove(indice);
        parcours.getListeDefis().add(defiEntity);
        repo.save(parcours);
    }

    public void interchangerDefisDansParcours(Integer idParcours, Integer idDefiARemplacer, Integer idDefiAAjouter) throws Exception {
        Optional<ParcoursEntity> parcoursEntity = this.repo.findById(idParcours);
        if (parcoursEntity.isEmpty())throw new Exception();
        ParcoursEntity parcours = parcoursEntity.get();
        DefiEntity defiEntity = repoDefi.findByIdDefi(idDefiAAjouter);
        List<DefiEntity> listeDefis = new ArrayList();
        listeDefis.addAll(parcours.getListeDefis());
        int indice = 0;
        for (int i = 0; i < listeDefis.size(); i++) {
            if (listeDefis.get(i).getIdDefi() == idDefiARemplacer) { //est-ce que l'id à remplacer est bien présent dans la liste
                indice = i;
            }
        }
        this.repoDefi.save(defiEntity);
        parcours.getListeDefis().remove(indice);
        parcours.getListeDefis().add(defiEntity);
        repo.save(parcours);
    }


//-------------------laboratoire expérimental :


    // méthode pour "remplacer" -> suppr + add



    //------------------
}
