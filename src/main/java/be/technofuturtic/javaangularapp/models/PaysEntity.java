package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<UtilisateurEntity> utilisateurs = new ArrayList<>();
}
