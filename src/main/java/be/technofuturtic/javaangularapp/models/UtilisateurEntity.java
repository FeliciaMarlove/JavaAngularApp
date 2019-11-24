package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Utilisateur", schema = "public", catalog = "javaangulardb")
public class UtilisateurEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_utilisateur")
    private Long idUtilisateur;

    @Column(name = "nom", nullable = false)
    private String nomUtilisateur;

    @Column(name = "prenom", nullable = false)
    private String prenomUtilisateur;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaiss;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "motdepasse", nullable = false)
    private String motDePasse;

    @Column(name = "newsletter_optin", nullable = false)
    private boolean newsletterOptIn;

    @Column(name = "is_active", nullable = false)
    private boolean isActiveUtilisateur;

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isNewsletterOptIn() {
        return newsletterOptIn;
    }

    public void setNewsletterOptIn(boolean newsletterOptIn) {
        this.newsletterOptIn = newsletterOptIn;
    }

    public boolean isActiveUtilisateur() {
        return isActiveUtilisateur;
    }

    public void setActiveUtilisateur(boolean activeUtilisateur) {
        isActiveUtilisateur = activeUtilisateur;
    }

    //role
    //pays
}
