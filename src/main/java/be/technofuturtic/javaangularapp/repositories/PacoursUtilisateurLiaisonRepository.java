package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.PK_Parcours_Utilisateur;
import be.technofuturtic.javaangularapp.models.ParcoursUtilisateurLiaison;
import org.springframework.data.repository.CrudRepository;

public interface PacoursUtilisateurLiaisonRepository extends CrudRepository<ParcoursUtilisateurLiaison, PK_Parcours_Utilisateur> {
}
