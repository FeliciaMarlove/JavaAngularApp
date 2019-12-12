package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.models.ParcoursUtilisateurLiaison;
import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.utilitaires.ParcoursUtilisateurDto;

import java.time.LocalDate;
import java.util.List;

public interface ParcoursUtilisateurLiaisonService {
    /*List<ParcoursUtilisateurLiaison> findAll();*/
    List<ParcoursUtilisateurDto> findAll();
    Boolean commencerParcours(Integer parcours, Long utilisateur);
    DefiEntity voirDefiDuJour(Long idUtil);
    List<ParcoursUtilisateurLiaison> listerHistorique(Long idUtil);
    String retranscrireHistorique(Long idUtil);
}
