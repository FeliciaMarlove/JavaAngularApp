package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;

@Entity
@Table(name = "Parcours", schema = "public", catalog = "javaangulardb")
public class ParcoursEntity {

    @Id
    @GeneratedValue
    @Column(name = "id_parcours")
    private Integer idParcours;

    @Column(name = "nom", nullable = false)
    private String nomParcours;

    @Column(name = "description")
    private String descParcours;

    @Column(name = "prix")
    private double prix;

    @Column(name = "is_active", nullable = false)
    private boolean isActiveParcours;

    public Integer getIdParcours() {
        return idParcours;
    }

    public String getNomParcours() {
        return nomParcours;
    }

    public void setNomParcours(String nomParcours) {
        this.nomParcours = nomParcours;
    }

    public String getDescParcours() {
        return descParcours;
    }

    public void setDescParcours(String descParcours) {
        this.descParcours = descParcours;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isActiveParcours() {
        return isActiveParcours;
    }

    public void setActiveParcours(boolean activeParcours) {
        isActiveParcours = activeParcours;
    }

    //catégorie
    //liste défis
}
