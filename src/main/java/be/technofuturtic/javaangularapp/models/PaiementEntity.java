package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;
import java.io.Serializable;

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
}
