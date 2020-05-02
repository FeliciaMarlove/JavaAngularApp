package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import org.springframework.data.repository.CrudRepository;
/*
import org.springframework.security.core.userdetails.UserDetails;
*/

import java.util.Optional;

public interface UtilisateurRepository extends CrudRepository<UtilisateurEntity, Long> {
   // Optional<UserDetails> findByEmail(String email);
    UtilisateurEntity findByEmail(String email);
    UtilisateurEntity findByIdUtilisateur(Long id);
}
