package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.repositories.ParcoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcoursServiceImplemented implements ParcoursService {
    private ParcoursRepository repo;

    @Autowired
    public ParcoursServiceImplemented(ParcoursRepository repository) {
       repo = repository;
    }


    @Override
    public List<ParcoursEntity> findAll() {
        return (List<ParcoursEntity>) repo.findAll();
    }
}
