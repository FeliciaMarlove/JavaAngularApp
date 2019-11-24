package be.technofuturtic.javaangularapp.models;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.io.Serializable;

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
}
