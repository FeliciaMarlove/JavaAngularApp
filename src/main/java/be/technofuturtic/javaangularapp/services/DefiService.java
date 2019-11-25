package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.DefiEntity;

import java.util.List;

public interface DefiService {
    public List<DefiEntity> findAll();
    void desactiverDefi(Integer idDefi);
    void activerDefi(Integer idDefi);
    void ajouterDefi(DefiEntity nouveauDefi);
}
