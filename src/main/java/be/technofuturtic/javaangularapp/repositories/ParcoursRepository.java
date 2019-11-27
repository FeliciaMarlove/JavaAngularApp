package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParcoursRepository extends CrudRepository<ParcoursEntity, Integer> {

}
