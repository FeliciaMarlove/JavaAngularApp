package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.models.ParcoursUtilisateurLiaison;
import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.repositories.PacoursUtilisateurLiaisonRepository;
import be.technofuturtic.javaangularapp.repositories.ParcoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ParcoursUtilisateurLiaisonServiceImplemented implements ParcoursUtilisateurLiaisonService {
    private PacoursUtilisateurLiaisonRepository repo;
    private ParcoursRepository parcours;

    @Autowired
    public ParcoursUtilisateurLiaisonServiceImplemented(PacoursUtilisateurLiaisonRepository repository) {
        repo = repository;
    }


    @Override
    public List<ParcoursUtilisateurLiaison> findAll() {
        return (List<ParcoursUtilisateurLiaison>) repo.findAll();
    }

    @Override
    public void commencerParcours(ParcoursEntity parcours, UtilisateurEntity utilisateur) {
        repo.save(new ParcoursUtilisateurLiaison(parcours, utilisateur));
    }

    @Override
    public DefiEntity voirDefiDuJour(ParcoursUtilisateurLiaison parcoursUtil) {
        LocalDate dateDebut = parcoursUtil.getParcoursUtilId().getDateParcUtil();
        LocalDate dateDuJour = LocalDate.now();
        int deltaJours = Period.between(dateDebut, dateDuJour).getDays();
        int numDefi = deltaJours-1;
        Optional<ParcoursEntity> p = parcours.findById(parcoursUtil.getParcoursUtilId().getIdParc());
        if (deltaJours <= p.get().getListeDefis().size()) {
            return p.get().getListeDefis().get(numDefi);
        }
        return null;
    }
}
