package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.PK_Parcours_Utilisateur;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.models.ParcoursUtilisateurLiaison;
import be.technofuturtic.javaangularapp.repositories.DefiRepository;
import be.technofuturtic.javaangularapp.repositories.PacoursUtilisateurLiaisonRepository;
import be.technofuturtic.javaangularapp.repositories.ParcoursRepository;
import be.technofuturtic.javaangularapp.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParcoursServiceImplemented implements ParcoursService {
    private ParcoursRepository repo;
    private DefiRepository repoDefi;

    @Autowired
    public ParcoursServiceImplemented(ParcoursRepository repository, DefiRepository defiRepository) {
       repo = repository;
       repoDefi = defiRepository;
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
    public void modifierDefiDansParcours(Integer idParcours, Integer idDefiARemplacer, DefiEntity nouveauDefi) {
        Optional<ParcoursEntity> parcoursModif = repo.findById(idParcours);
        List<DefiEntity> listeDefis = new ArrayList(parcoursModif.get().getListeDefis()); // liste de DefiEntity du Parcours
        for (int i = 0; i < listeDefis.size(); i++) {
            if (listeDefis.get(i).getIdDefi() == idDefiARemplacer) { //est-ce que l'id à remplacer est bien présent dans la liste
                listeDefis.remove(i);
                listeDefis.add(i, nouveauDefi);
            }
        }
    }

    @Override
    public void modifierDefiDansParcours(Integer idParcours, Integer idDefiARemplacer, Integer idDefiAAjouter) {
        Optional<ParcoursEntity> parcoursModif = repo.findById(idParcours);
        List<DefiEntity> listeDefis = new ArrayList(parcoursModif.get().getListeDefis());
        for (int i = 0; i < listeDefis.size(); i++) {
            if (listeDefis.get(i).getIdDefi() == idDefiARemplacer) {
                listeDefis.remove(i);
                listeDefis.add(i, repoDefi.findByIdDefi(idDefiAAjouter));
            }
        }
    }

    @Override
    public void ajouterDefiDansParcours(Integer idParcours, DefiEntity nouveauDefi) {
        Optional<ParcoursEntity> parcoursModif = repo.findById(idParcours);
        parcoursModif.get().getListeDefis().add(nouveauDefi);
        repoDefi.save(nouveauDefi);
        repo.save(parcoursModif.get());
        //doit enregistrer un (Parcours?)Entity
    }
}
