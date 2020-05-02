package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.utilitaires.DefiEntityDto;

import java.util.List;

public interface DefiService {
    public List<DefiEntity> findAll();
    void desactiverDefi(Integer idDefi);
    void activerDefi(Integer idDefi);
    Boolean creerDefi(DefiEntityDto nouveauDefi);
    List<DefiEntity> listerActifs();
    Boolean majDefi(Integer idDefi, DefiEntityDto updateDefi);
    Integer getIdCategorie(Integer idDefi);
}
