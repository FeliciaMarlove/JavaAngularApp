package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.PaiementEntity;
import org.springframework.data.repository.CrudRepository;

public interface PaiementRepository extends CrudRepository<PaiementEntity, Integer> {
}
