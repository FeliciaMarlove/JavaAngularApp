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
        UtilisateurEntity u = repo.findById(idUtilisateur).get();
        u.setActiveUtilisateur(false);
        repo.save(u);
    }

    @Override
    public void activerUtilisateur(Long idUtilisateur) {
        UtilisateurEntity u = repo.findById(idUtilisateur).get();
        u.setActiveUtilisateur(true);
        repo.save(u);
    }

    @Override
    public void creerCompte(UtilisateurEntity nouvelUtilisateur) {
        boolean isDuplicate = false;
        List<UtilisateurEntity> utilisateursExistants = findAll();
        for (int i = 0; i < utilisateursExistants.size(); i++) {
            if (nouvelUtilisateur.equals(utilisateursExistants.get(i))) {
                isDuplicate = true;
            }
        }
        if(!isDuplicate) {
            nouvelUtilisateur.setActiveUtilisateur(true);
            repo.save(nouvelUtilisateur);
        }
    }
}
