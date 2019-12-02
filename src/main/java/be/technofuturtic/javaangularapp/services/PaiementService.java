package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.PaiementEntity;
import be.technofuturtic.javaangularapp.utilitaires.PaiementEntityDto;

import java.util.List;

public interface PaiementService {
    public List<PaiementEntity> findAll();
    void desactiverPaiement(Integer idPaiement);
    void activerPaiement(Integer idPaiement);
    void ajouterPaiement(PaiementEntityDto nouveauPaiement);
}
