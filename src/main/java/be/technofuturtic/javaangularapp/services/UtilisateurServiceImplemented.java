package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImplemented implements UtilisateurService {
    private UtilisateurRepository repo;

    @Autowired
    public UtilisateurServiceImplemented(UtilisateurRepository repository) {
        repo = repository;
    }

    @Override
    public List<UtilisateurEntity> findAll() {
        return (List<UtilisateurEntity>) repo.findAll();
    }

    @Override
    public void desactiverUtilisateur(Long idUtilisateur) {
        repo.findById(idUtilisateur).get().setActiveUtilisateur(false);
    }

    @Override
    public void activerUtilisateur(Long idUtilisateur) {
        repo.findById(idUtilisateur).get().setActiveUtilisateur(true);
    }
}
