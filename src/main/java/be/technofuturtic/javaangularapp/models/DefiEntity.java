package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Defi", schema = "public", catalog = "javaangulardb")
public class DefiEntity  implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_defi")
    private Integer idDefi;

    @Column(name = "nom", nullable = false, unique = true)
    private String nomDefi;

    @Column(name = "description", nullable = false)
    private String descDefi;

    @Column(name = "infobulle")
    private String infobulleDefi;

    @Column(name = "is_active", nullable = false)
    private boolean isActiveDefi;

    public Integer getIdDefi() {
        return idDefi;
    }

    public String getNomDefi() {
        return nomDefi;
    }

    public void setNomDefi(String nomDefi) {
        this.nomDefi = nomDefi;
    }

    public String getDescDefi() {
        return descDefi;
    }

    public void setDescDefi(String descDefi) {
        this.descDefi = descDefi;
    }

    public String getInfobulleDefi() {
        return infobulleDefi;
    }

    public void setInfobulleDefi(String infobulleDefi) {
        this.infobulleDefi = infobulleDefi;
    }

    public boolean isActiveDefi() {
        return isActiveDefi;
    }

    public void setActiveDefi(boolean activeDefi) {
        isActiveDefi = activeDefi;
    }

    @ManyToOne(targetEntity = CategorieEntity.class)
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie", foreignKey = @ForeignKey(name = "FK_Defi_Categorie"))
    private CategorieEntity categorie;

    @ManyToMany
    (mappedBy = "listeDefis")
    private Set<ParcoursEntity> listeParcours;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefiEntity that = (DefiEntity) o;
        return isActiveDefi == that.isActiveDefi &&
                Objects.equals(idDefi, that.idDefi) &&
                Objects.equals(nomDefi, that.nomDefi) &&
                Objects.equals(descDefi, that.descDefi) &&
                Objects.equals(infobulleDefi, that.infobulleDefi) &&
                Objects.equals(categorie, that.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDefi, nomDefi, descDefi, infobulleDefi, isActiveDefi, categorie);
    }

    public DefiEntity(String nomDefi, String descDefi, String infobulleDefi, CategorieEntity categorie) {
        this.nomDefi = nomDefi;
        this.descDefi = descDefi;
        this.infobulleDefi = infobulleDefi;
        this.isActiveDefi = true;
        this.categorie = categorie;
    }

    public DefiEntity() {
    }
}
