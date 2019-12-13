package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.repositories.*;
import be.technofuturtic.javaangularapp.utilitaires.DefiEntityDto;
import be.technofuturtic.javaangularapp.utilitaires.ParcoursEntityDto;
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
    public ParcoursServiceImplemented(ParcoursRepository repository, DefiRepository defiRepository, CategorieRepository categorieRepository) {
       repo = repository;
       repoDefi = defiRepository;
       repoCat = categorieRepository;
    }

    @Override
    public List<ParcoursEntity> findAll() {
        return (List<ParcoursEntity>) repo.findAll();
    }

    @Override
    public List<ParcoursEntity> findActive() {
        List<ParcoursEntity> all = findAll();
        List<ParcoursEntity> active = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).isActiveParcours()) {
                active.add(all.get(i));
            }
        }
        return active;
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
    public Boolean majParcours(Integer idParcours, ParcoursEntityDto parcoursDto) {
        Boolean isDuplicate = isDuplicate(parcoursDto);
        if (!isDuplicate) {
            ParcoursEntity p = repo.findById(idParcours).get();
            p.setNomParcours(parcoursDto.getNomParcours());
            p.setDescParcours(parcoursDto.getDescParcours());
            p.setPrix(parcoursDto.getPrix());
            Optional<CategorieEntity> categorieEntityOptional = this.repoCat.findById(parcoursDto.getCategorieId());
            CategorieEntity c = categorieEntityOptional.get();
            p.setCategorie(c);
            repo.save(p);
        }
        return isDuplicate;
    }

    @Override
    public List<DefiEntity> listDefis(Integer idParcours) {
        ParcoursEntity p = repo.findById(idParcours).get();
        return p.getListeDefis();
    }

    @Override
    public Boolean ajouterParcours(ParcoursEntityDto parcDto) {
        Boolean isDuplicate = isDuplicate(parcDto);
        if(!isDuplicate) {
            Optional<CategorieEntity> categorieEntityOptional = this.repoCat.findById(parcDto.getCategorieId());
            //CategorieEntity c = categorieEntityOptional.get();
            ParcoursEntity p = new ParcoursEntity(
                    parcDto.getNomParcours(),
                    parcDto.getDescParcours(),
                    parcDto.getPrix(),
                    categorieEntityOptional
            );
            p.setActiveParcours(true);
            this.repo.save(p);
        }
        return isDuplicate;
    }

    private Boolean isDuplicate(ParcoursEntityDto parcours) {
        Boolean isDuplicate = false;
        List<ParcoursEntity> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getNomParcours().equals(parcours.getNomParcours())) {
                isDuplicate = true;
            }
        }
        return isDuplicate;
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
        if (defiEntity.isActiveDefi()) {
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
    }

    public Boolean ajouterDefiDansParcours(Integer idParcours, Integer idDefiAAjouter) throws Exception {
        Optional<ParcoursEntity> parcoursEntity = this.repo.findById(idParcours);
        if (parcoursEntity.isEmpty())throw new Exception();
        ParcoursEntity parcours = parcoursEntity.get();
        DefiEntity defiEntity = repoDefi.findByIdDefi(idDefiAAjouter);
        for (int i = 0; i < parcours.getListeDefis().size(); i++) {
            if (parcours.getListeDefis().get(i).getIdDefi() == defiEntity.getIdDefi()) {
                return false;
            }
        }
        if (defiEntity.isActiveDefi()) {
            parcours.getListeDefis().add(defiEntity);
            repo.save(parcours);
            return true;
        }
        return true;
    }

}
