package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.*;
import be.technofuturtic.javaangularapp.repositories.PacoursUtilisateurLiaisonRepository;
import be.technofuturtic.javaangularapp.repositories.ParcoursRepository;
import be.technofuturtic.javaangularapp.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class ParcoursUtilisateurLiaisonServiceImplemented implements ParcoursUtilisateurLiaisonService {
    private PacoursUtilisateurLiaisonRepository repo;
    private ParcoursRepository parcoursRepo;
    private UtilisateurRepository utilisateurRepo;

    @Autowired
    public ParcoursUtilisateurLiaisonServiceImplemented(PacoursUtilisateurLiaisonRepository repo, ParcoursRepository parcoursRepo, UtilisateurRepository utilisateurRepo) {
        this.repo = repo;
        this.parcoursRepo = parcoursRepo;
        this.utilisateurRepo = utilisateurRepo;
    }

    @Override
    public List<ParcoursUtilisateurLiaison> findAll() {
        return (List<ParcoursUtilisateurLiaison>) repo.findAll();
    }

    @Override
    public void commencerParcours(Integer parcours, Long utilisateur) {
        ParcoursEntity p = parcoursRepo.findById(parcours).get();
        UtilisateurEntity u = utilisateurRepo.findById(utilisateur).get();
        ParcoursUtilisateurLiaison pul = new ParcoursUtilisateurLiaison(p, u);
        repo.save(pul);
        u.ajouterRelationParcours(pul);
        utilisateurRepo.save(u);
        p.ajouterRelationParcours(pul);
        parcoursRepo.save(p);
        repo.save(pul);
        System.out.println(pul.getParcoursUtilId());
    }

    @Override
    public DefiEntity voirDefiDuJour(Long idUtilisateur) {
        ParcoursUtilisateurLiaison pul = repo.findByParcoursUtilId(trouverLeParcoursEnCoursDeGerard(trouverGerard(idUtilisateur)));
        if (pul != null) {
            LocalDate dateDebut = pul.getDateAchat();
            LocalDate dateDuJour = LocalDate.now();
            int deltaJours = Period.between(dateDebut, dateDuJour).getDays();
            Optional<ParcoursEntity> p = parcoursRepo.findById(pul.getParcoursUtilId().getIdParc());
            if (deltaJours <= p.get().getListeDefis().size()) {
                return p.get().getListeDefis().get(deltaJours);
            }
            return null;
        } else {
            return null;
        }
    }

    @Override
    public List<ParcoursUtilisateurLiaison> listerHistorique(Long idUtil) {
        UtilisateurEntity u = utilisateurRepo.findById(idUtil).get();
        List<ParcoursUtilisateurLiaison> liste = repo.findAllByUtilisateurEquals(u);
        return liste;
    }

    @Override
    public String retranscrireHistorique(Long idUtil) {
        StringBuilder affichage = new StringBuilder(" ");
        UtilisateurEntity u = utilisateurRepo.findById(idUtil).get();
        List<ParcoursUtilisateurLiaison> liste = listerHistorique(idUtil);
        affichage.append("Historique des parcours de l'utilisateur ").append(idUtil).append(" ").append(u.getPrenomUtilisateur()).append(" ").append(u.getNomUtilisateur()).append(" ").append(u.getEmail()).append(" : ");
        for (int i = 0; i < liste.size(); i++) {
            affichage.append("\n").append(liste.get(i).getParcoursUtilId()).append(liste.get(i).getParcours().getNomParcours()).append(" commencé le ").append(liste.get(i).getDateAchat()).append(" payé ").append(liste.get(i).getPrixAchat());
        }
        return affichage.toString();
    }

    private UtilisateurEntity trouverGerard(Long idUtil) {
        UtilisateurEntity u = utilisateurRepo.findById(idUtil).get();
        return u;
    }

    private PK_Parcours_Utilisateur trouverLeParcoursEnCoursDeGerard(UtilisateurEntity gerardLuiMeme) {
        List<ParcoursUtilisateurLiaison> pulList = null;

        System.out.println(gerardLuiMeme.getListeParcoursUtilisateurs().isEmpty());

        if (gerardLuiMeme.isActiveUtilisateur() && !gerardLuiMeme.getListeParcoursUtilisateurs().isEmpty()) {
              pulList = repo.findAllByUtilisateurEquals(gerardLuiMeme);
        }
        ParcoursUtilisateurLiaison pulActif = null;
        for (int i = 0; i < pulList.size(); i++) {
            if (pulList.get(i).isOngoing()) {
                pulActif = pulList.get(i);
            }
        }
        return pulActif.getParcoursUtilId();
    }
}
