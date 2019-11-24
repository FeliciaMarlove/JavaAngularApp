package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Parcours", schema = "public", catalog = "javaangulardb")
public class ParcoursEntity implements Serializable {

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

    @ManyToOne(targetEntity = CategorieEntity.class)
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie", foreignKey = @ForeignKey(name = "FK_Parcours_Categorie"))
    private CategorieEntity categorie;

    @ManyToMany(mappedBy = "listeParcours")
    private Set<DefiEntity> listeDefis = new HashSet<>();
}
