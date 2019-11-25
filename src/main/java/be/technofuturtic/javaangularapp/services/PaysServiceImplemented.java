package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.PaysEntity;
import be.technofuturtic.javaangularapp.repositories.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaysServiceImplemented implements PaysService {
    private PaysRepository repo;

    @Autowired
    public PaysServiceImplemented(PaysRepository repository) {
        repo = repository;
    }


    @Override
    public List<PaysEntity> findAll() {
        return (List<PaysEntity>) repo.findAll();
    }
}
