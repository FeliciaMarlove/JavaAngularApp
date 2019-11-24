package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Role", schema = "public", catalog = "javaangulardb")
public class RoleEntity  implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_role")
    private Integer idRole;

    @Column(name = "nom_role", nullable = false, unique = true)
    private String nomRole;

    public Integer getIdRole() {
        return idRole;
    }

    public String getNomRole() {
        return nomRole;
    }

    public void setNomRole(String nomRole) {
        this.nomRole = nomRole;
    }

    @OneToMany(mappedBy = "role", targetEntity = UtilisateurEntity.class)
    private List<UtilisateurEntity> utilisateurs = new ArrayList<>();
}
