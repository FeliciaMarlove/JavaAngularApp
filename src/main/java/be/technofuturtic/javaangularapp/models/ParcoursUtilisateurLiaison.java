package be.technofuturtic.javaangularapp.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "parcours_utilisateur")
public class ParcoursUtilisateurLiaison implements Serializable {

    @EmbeddedId
    private PK_Parcours_Utilisateur parcoursUtilId;

    public PK_Parcours_Utilisateur getParcoursUtilId() {
        return parcoursUtilId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParcoursUtilisateurLiaison that = (ParcoursUtilisateurLiaison) o;
        return Objects.equals(parcoursUtilId, that.parcoursUtilId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parcoursUtilId);
    }
}
