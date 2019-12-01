package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.models.ParcoursUtilisateurLiaison;
import be.technofuturtic.javaangularapp.models.UtilisateurEntity;

import java.time.LocalDate;
import java.util.List;

public interface ParcoursUtilisateurLiaisonService {
    public List<ParcoursUtilisateurLiaison> findAll();
    void commencerParcours(Integer parcours, Long utilisateur);
    DefiEntity voirDefiDuJour(Long idUtil);
    List<ParcoursUtilisateurLiaison> listerHistorique(Long idUtil);
    String retranscrireHistorique(Long idUtil);
}
