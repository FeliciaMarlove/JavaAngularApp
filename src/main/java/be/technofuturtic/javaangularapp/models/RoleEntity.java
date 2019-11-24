package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;

@Entity
@Table(name = "Role", schema = "public", catalog = "javaangulardb")
public class RoleEntity {

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
}
