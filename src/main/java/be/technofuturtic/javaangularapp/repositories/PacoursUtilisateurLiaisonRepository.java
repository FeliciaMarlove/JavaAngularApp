package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.PK_Parcours_Utilisateur;
import be.technofuturtic.javaangularapp.models.ParcoursUtilisateurLiaison;
import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PacoursUtilisateurLiaisonRepository extends CrudRepository<ParcoursUtilisateurLiaison, PK_Parcours_Utilisateur> {
    List<ParcoursUtilisateurLiaison> findAllByUtilisateurEquals(UtilisateurEntity utilisateurEntity);
    ParcoursUtilisateurLiaison findByParcoursUtilId(PK_Parcours_Utilisateur pk);

}
