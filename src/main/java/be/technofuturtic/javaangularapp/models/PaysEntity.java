package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Pays", schema = "public", catalog = "javaangulardb")
public class PaysEntity  implements Serializable {

    @Id
    //@GeneratedValue
    @Column(name = "id_pays")
    private Integer idPays;

    @Column(name = "code")
    private int code;

    @Column(name = "alpha2")
    private String alpha2;

    @Column(name = "alpha3")
    private String alpha3;

    @Column(name = "nom_fr")
    private String nomFr;

    @Column(name = "nom_en")
    private String nomEn;

    public Integer getIdPays() {
        return idPays;
    }

    public int getCode() {
        return code;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public String getNomFr() {
        return nomFr;
    }

    public String getNomEn() {
        return nomEn;
    }

    @OneToMany(mappedBy = "pays", targetEntity = UtilisateurEntity.class)
    private List<UtilisateurEntity> utilisateurs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaysEntity that = (PaysEntity) o;
        return code == that.code &&
                Objects.equals(idPays, that.idPays) &&
                Objects.equals(alpha2, that.alpha2) &&
                Objects.equals(alpha3, that.alpha3) &&
                Objects.equals(nomFr, that.nomFr) &&
                Objects.equals(nomEn, that.nomEn) &&
                Objects.equals(utilisateurs, that.utilisateurs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPays, code, alpha2, alpha3, nomFr, nomEn, utilisateurs);
    }
}
