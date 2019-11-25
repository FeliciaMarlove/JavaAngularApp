package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.RoleEntity;
import be.technofuturtic.javaangularapp.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplemented implements RoleService {
    private RoleRepository repo;

    @Autowired
    public RoleServiceImplemented(RoleRepository repository) {
        repo = repository;
    }

    @Override
    public List<RoleEntity> findAll() {
        return (List<RoleEntity>) repo.findAll();
    }
}
