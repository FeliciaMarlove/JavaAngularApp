package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.PaiementEntity;
import be.technofuturtic.javaangularapp.repositories.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImplemented implements PaiementService {
    private PaiementRepository repo;

    @Autowired
    public PaiementServiceImplemented(PaiementRepository repository) {
        repo = repository;
    }


    @Override
    public List<PaiementEntity> findAll() {
        return (List<PaiementEntity>) repo.findAll();
    }

    @Override
    public void desactiverPaiement(Integer idPaiement) {
        repo.findById(idPaiement).get().setActivePaiement(false);
    }

    @Override
    public void activerPaiement(Integer idPaiement) {
        repo.findById(idPaiement).get().setActivePaiement(true);
    }

    @Override
    public void ajouterPaiement(PaiementEntity nouveauPaiement) {
        repo.save(nouveauPaiement);
    }
}