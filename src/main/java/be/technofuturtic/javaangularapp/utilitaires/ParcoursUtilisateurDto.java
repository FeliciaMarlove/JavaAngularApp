package be.technofuturtic.javaangularapp.utilitaires;

import java.time.LocalDate;

public class ParcoursUtilisateurDto {
    private Integer idParcours;
    private String nomParcours;
    private Long idUtilisateur;
    private String email;
    private LocalDate dateAchat;
    private boolean isOngoing;
    private int taille;

    public ParcoursUtilisateurDto(Integer idParcours, String nomParcours, Long idUtilisateur, String email, LocalDate dateAchat, boolean isOngoing, int taille) {
        this.idParcours = idParcours;
        this.nomParcours = nomParcours;
        this.idUtilisateur = idUtilisateur;
        this.email = email;
        this.dateAchat = dateAchat;
        this.isOngoing = isOngoing;
        this.taille = taille;
    }

    public Integer getIdParcours() {
        return idParcours;
    }

    public String getNomParcours() {
        return nomParcours;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public boolean isOngoing() {
        return isOngoing;
    }

    public int getTaille() {
        return taille;
    }
}
