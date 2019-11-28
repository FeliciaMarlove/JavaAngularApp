package be.technofuturtic.javaangularapp.models;

import be.technofuturtic.javaangularapp.utilitaires.DefiEntityDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
        if (prix >= 0) {
            this.prix = prix;
        } else {
            this.prix = Math.abs(prix);
        }
    }

    public boolean isActiveParcours() {
        return isActiveParcours;
    }

    public void setActiveParcours(boolean activeParcours) {
        isActiveParcours = activeParcours;
    }

    public List<DefiEntity> getListeDefis() {
        return listeDefis;
    }

    public void setListeDefis(List<DefiEntity> listeDefis) {
        this.listeDefis = listeDefis;
    }

    @ManyToOne(targetEntity = CategorieEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie", foreignKey = @ForeignKey(name = "FK_Parcours_Categorie"))
    private CategorieEntity categorie;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Parcours_Defis", joinColumns = @JoinColumn(name = "id_parcours"), inverseJoinColumns = @JoinColumn( name = "id_defi"))
    private List<DefiEntity> listeDefis;

    @OneToMany(mappedBy = "parcours", targetEntity = ParcoursUtilisateurLiaison.class, fetch = FetchType.LAZY)
    private List<ParcoursUtilisateurLiaison> listePUP;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParcoursEntity that = (ParcoursEntity) o;
        return Double.compare(that.prix, prix) == 0 &&
                isActiveParcours == that.isActiveParcours &&
                Objects.equals(idParcours, that.idParcours) &&
                Objects.equals(nomParcours, that.nomParcours) &&
                Objects.equals(descParcours, that.descParcours) &&
                Objects.equals(categorie, that.categorie) &&
                Objects.equals(listeDefis, that.listeDefis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParcours, nomParcours, descParcours, prix, isActiveParcours, categorie, listeDefis);
    }

    public ParcoursEntity(String nomParcours, String descParcours, double prix, CategorieEntity categorie) {
        this();
        this.nomParcours = nomParcours;
        this.descParcours = descParcours;
        this.prix = prix;
        this.categorie = categorie;
    }

    public ParcoursEntity() {
        this.listeDefis = new ArrayList<>();
        this.listePUP = new ArrayList<>();
        this.isActiveParcours = true;
    }
}
