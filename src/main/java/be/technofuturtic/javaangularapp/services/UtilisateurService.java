package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.repositories.UtilisateurRepository;

import java.util.List;

public interface UtilisateurService {
    public List<UtilisateurEntity> findAll();
    void desactiverUtilisateur(Long idUtilisateur);
    void activerUtilisateur(Long idUtilisateur);
    void creerCompte(UtilisateurEntity nouvelUtilisateur);
}
