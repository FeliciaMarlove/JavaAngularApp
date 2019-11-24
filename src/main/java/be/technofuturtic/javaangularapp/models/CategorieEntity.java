package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Categorie", schema = "public", catalog = "javaangulardb")
public class CategorieEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_categorie")
    private Integer idCategorie;

    @Column(name = "nom", nullable = false)
    private String nomCategorie;

    @Column(name = "description")
    private String descCategorie;

    @Column(name = "is_active", nullable = false)
    private boolean isActiveCategorie;

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getDescCategorie() {
        return descCategorie;
    }

    public void setDescCategorie(String descCategorie) {
        this.descCategorie = descCategorie;
    }

    public boolean isActiveCategorie() {
        return isActiveCategorie;
    }

    public void setActiveCategorie(boolean activeCategorie) {
        isActiveCategorie = activeCategorie;
    }

    @OneToMany(mappedBy = "categorie", targetEntity = DefiEntity.class)
    private List<DefiEntity> defis = new ArrayList<>();

    @OneToMany(mappedBy = "categorie", targetEntity = ParcoursEntity.class)
    private List<ParcoursEntity> categories = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieEntity that = (CategorieEntity) o;
        return isActiveCategorie == that.isActiveCategorie &&
                Objects.equals(idCategorie, that.idCategorie) &&
                Objects.equals(nomCategorie, that.nomCategorie) &&
                Objects.equals(descCategorie, that.descCategorie) &&
                Objects.equals(defis, that.defis) &&
                Objects.equals(categories, that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategorie, nomCategorie, descCategorie, isActiveCategorie, defis, categories);
    }
}
