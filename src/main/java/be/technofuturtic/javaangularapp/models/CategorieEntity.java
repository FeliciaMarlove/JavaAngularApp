package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
}
