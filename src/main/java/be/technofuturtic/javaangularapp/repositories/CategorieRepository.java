package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository extends CrudRepository<CategorieEntity, Integer> {
}
