package be.technofuturtic.javaangularapp.repositories;

import be.technofuturtic.javaangularapp.models.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
}
