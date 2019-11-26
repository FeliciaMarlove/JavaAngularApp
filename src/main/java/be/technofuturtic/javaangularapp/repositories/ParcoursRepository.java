package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ParcoursRepository extends CrudRepository<ParcoursEntity, Integer> {


    /*@Query(value = "SELECT s FROM StudentEntity s WHERE s.firstName = :firstname")
    StudentEntity findByFirstName(@Param("firstname") String firstname);*/
}
