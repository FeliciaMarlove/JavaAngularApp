package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.ParcoursUtilisateurLiaison;
import be.technofuturtic.javaangularapp.repositories.PacoursUtilisateurLiaisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcoursUtilisateurLiaisonServiceImplemented implements ParcoursUtilisateurLiaisonService {
    private PacoursUtilisateurLiaisonRepository repo;

    @Autowired
    public ParcoursUtilisateurLiaisonServiceImplemented(PacoursUtilisateurLiaisonRepository repository) {
        repo = repository;
    }


    @Override
    public List<ParcoursUtilisateurLiaison> findAll() {
        return (List<ParcoursUtilisateurLiaison>) repo.findAll();
    }
}
