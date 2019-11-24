package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import org.springframework.data.repository.CrudRepository;

public interface DefiRepository extends CrudRepository<DefiEntity, Integer> {
}
