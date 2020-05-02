package be.technofuturtic.javaangularapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @OneToMany(mappedBy = "role", targetEntity = UtilisateurEntity.class, fetch = FetchType.LAZY)
    private List<UtilisateurEntity> utilisateurs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(nomRole, that.nomRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, nomRole, utilisateurs);
    }

    public RoleEntity(String nomRole) {
        this();
        this.nomRole = nomRole;
    }

    public RoleEntity() {
        this.utilisateurs = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "idRole=" + idRole +
                ", nomRole='" + nomRole + '\'' +
                '}';
    }
}
