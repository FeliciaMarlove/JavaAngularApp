package be.technofuturtic.javaangularapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Paiement", schema = "public", catalog = "javaangulardb")
public class PaiementEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_paiement")
    private Integer idPaiement;

    @Column(name = "nom", nullable = false)
    private String nomPaiement;

    @Column(name = "description")
    private String descPaiement;

    @Column(name = "is_active", nullable = false)
    private boolean isActivePaiement;

    public Integer getIdPaiement() {
        return idPaiement;
    }

    public String getNomPaiement() {
        return nomPaiement;
    }

    public void setNomPaiement(String nomPaiement) {
        this.nomPaiement = nomPaiement;
    }

    public String getDescPaiement() {
        return descPaiement;
    }

    public void setDescPaiement(String descPaiement) {
        this.descPaiement = descPaiement;
    }

    public boolean isActivePaiement() {
        return isActivePaiement;
    }

    public void setActivePaiement(boolean activePaiement) {
        isActivePaiement = activePaiement;
    }

    @OneToMany(mappedBy = "paiement", targetEntity = ParcoursUtilisateurLiaison.class, fetch = FetchType.LAZY)
    @JsonBackReference //avoids infiite recursion (works with @JsonManagedReference on the ManyToOne side)
    private List<ParcoursUtilisateurLiaison> listeParcoursUtilisateurLiaisons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaiementEntity that = (PaiementEntity) o;
        return Objects.equals(nomPaiement, that.nomPaiement) &&
                Objects.equals(descPaiement, that.descPaiement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPaiement, nomPaiement, descPaiement, isActivePaiement);
    }

    public PaiementEntity(String nomPaiement, String descPaiement) {
        this();
        this.nomPaiement = nomPaiement;
        this.descPaiement = descPaiement;
        this.setActivePaiement(true);
    }

    public PaiementEntity() {
        this.listeParcoursUtilisateurLiaisons = new ArrayList<>();
        this.isActivePaiement = true;
    }
}
