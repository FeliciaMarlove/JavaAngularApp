package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DefiRepository extends CrudRepository<DefiEntity, Integer> {
    DefiEntity findByNomDefi(String nomDefi);
    DefiEntity findByIdDefi (Integer idDefi);
}
