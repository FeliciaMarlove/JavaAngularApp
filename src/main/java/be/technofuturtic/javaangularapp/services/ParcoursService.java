package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.utilitaires.DefiEntityDto;
import be.technofuturtic.javaangularapp.utilitaires.ParcoursEntityDto;

import java.util.List;

public interface ParcoursService {
    public List<ParcoursEntity> findAll();
    void desactiverParcours(Integer idParcours);
    void activerParcours(Integer idParcours);
    void ajouterParcours(ParcoursEntity nouveauParcours);
    void modifierDefiDansParcours(Integer idParcours, Integer idDefiARemplacer, DefiEntityDto nouveauDefi) throws Exception;
    void interchangerDefisDansParcours(Integer idParcours, Integer idDefiARemplacer, Integer idDefiAInserer) throws Exception;
    void supprimerDefiDansParcours(Integer idParcours, Integer idDefiASupprimer);
    void ajouterDefiDansParcours(Integer idParcours, DefiEntityDto nouveauDefi) throws Exception;
    void majParcours(Integer idParcours, ParcoursEntityDto parcoursDto);
}
