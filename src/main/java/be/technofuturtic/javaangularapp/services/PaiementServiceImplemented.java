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
        PaiementEntity p = repo.findById(idPaiement).get();
        p.setActivePaiement(false);
        repo.save(p);
    }

    @Override
    public void activerPaiement(Integer idPaiement) {
        PaiementEntity p = repo.findById(idPaiement).get();
        p.setActivePaiement(true);
        repo.save(p);
    }

    @Override
    public void ajouterPaiement(PaiementEntity nouveauPaiement) {
        boolean isDuplicate = false;
        List<PaiementEntity> paiementsExistants = findAll();
        for (int i = 0; i < paiementsExistants.size(); i++) {
            if (nouveauPaiement.getNomPaiement().equals(paiementsExistants.get(i).getNomPaiement())) {
                isDuplicate = true;
            }
        }
        if (!isDuplicate) {
            repo.save(nouveauPaiement);
        }
    }
}
