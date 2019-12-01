package be.technofuturtic.javaangularapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "parcours_utilisateur", schema = "public", catalog = "javaangulardb")
public class ParcoursUtilisateurLiaison implements Serializable {

    @EmbeddedId
    private PK_Parcours_Utilisateur parcoursUtilId;

    public PK_Parcours_Utilisateur getParcoursUtilId() {
        return parcoursUtilId;
    }

    @Column(name = "date_achat")
    private LocalDate dateAchat;

    @ManyToOne(targetEntity = ParcoursEntity.class, fetch =  FetchType.EAGER)
    @JoinColumn(name = "id_parcours", referencedColumnName = "id_parcours", foreignKey = @ForeignKey(name = "FK_parcours_utilisateur_parcours"), insertable = false, updatable = false)
    private ParcoursEntity parcours;

    @ManyToOne(targetEntity = PaiementEntity.class, fetch =  FetchType.EAGER)
    @JoinColumn(name = "id_paiement", referencedColumnName = "id_paiement", foreignKey = @ForeignKey(name = "FK_parcours_utilisateur_paiement"), insertable = false, updatable = false)
    private PaiementEntity paiement;

    @ManyToOne(targetEntity = UtilisateurEntity.class, fetch =  FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", foreignKey = @ForeignKey(name = "FK_parcours_utilisateur_utilisateur"), insertable = false, updatable = false)
    private UtilisateurEntity utilisateur;

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setParcours(ParcoursEntity parcours) {
        this.parcours = parcours;
    }

    public void setPaiement(PaiementEntity paiement) {
        this.paiement = paiement;
    }

    public void setUtilisateur(UtilisateurEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Transient
    private boolean isOngoing;

    @Transient
    private int taille;

    public boolean isOngoing() {
        return isOngoing;
    }

    public void setOngoing(boolean ongoing) {
        isOngoing = ongoing;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public int getTaille() {
        return this.parcours.getListeDefis().size();
    }

    public UtilisateurEntity getUtilisateur() {
        return utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParcoursUtilisateurLiaison that = (ParcoursUtilisateurLiaison) o;
        return Objects.equals(parcoursUtilId, that.parcoursUtilId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parcoursUtilId);
    }

    public ParcoursUtilisateurLiaison(ParcoursEntity parcours, UtilisateurEntity utilisateur) {
        this();
        this.parcours = parcours;
        this.utilisateur = utilisateur;
    }

    public ParcoursUtilisateurLiaison() {
        this.dateAchat = LocalDate.now();
        this.isOngoing = true;
    }
}
