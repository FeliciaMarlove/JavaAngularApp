package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.repositories.UtilisateurRepository;
import be.technofuturtic.javaangularapp.utilitaires.AuthentificationDto;
import be.technofuturtic.javaangularapp.utilitaires.UtilisateurEntityDto;
/*
import org.springframework.security.core.userdetails.UserDetailsService;
*/

import java.util.List;

public interface UtilisateurService /*extends UserDetailsService*/ {
    public List<UtilisateurEntity> findAll();
    void desactiverUtilisateur(Long idUtilisateur);
    void activerUtilisateur(Long idUtilisateur);
    Boolean creerCompte(UtilisateurEntityDto nouvelUtilisateur);
    void majUtilisateur(UtilisateurEntityDto utilisateur, Long id);
    void inscrireNewsletter(Long idUtilisateur);
    void desinscrireNewsletter(Long idUtilisateur);
    Boolean login(AuthentificationDto logins);
    UtilisateurEntityDto findByEmail(String email);
}
