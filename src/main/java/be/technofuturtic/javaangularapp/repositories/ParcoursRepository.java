package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import org.springframework.data.repository.CrudRepository;

public interface ParcoursRepository extends CrudRepository<ParcoursEntity, Integer> {
}
