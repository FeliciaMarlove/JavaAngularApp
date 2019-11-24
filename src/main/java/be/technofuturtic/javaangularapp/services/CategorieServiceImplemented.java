package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImplemented implements CategorieService {
    private CategorieRepository repo;

    @Autowired
    public CategorieServiceImplemented(CategorieRepository repository) {
        repo = repository;
    }

    @Override
    public List<CategorieEntity> findAll() {
        return (List<CategorieEntity>) repo.findAll();
    }
}
