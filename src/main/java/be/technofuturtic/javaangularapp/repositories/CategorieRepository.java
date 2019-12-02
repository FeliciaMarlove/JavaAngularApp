package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategorieRepository extends CrudRepository<CategorieEntity, Integer> {

}
