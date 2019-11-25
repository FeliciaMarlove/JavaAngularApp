package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.PaiementEntity;

import java.util.List;

public interface PaiementService {
    public List<PaiementEntity> findAll();
    void desactiverPaiement(Integer idPaiement);
    void activerPaiement(Integer idPaiement);
    void ajouterPaiement(PaiementEntity nouveauPaiement);
}
