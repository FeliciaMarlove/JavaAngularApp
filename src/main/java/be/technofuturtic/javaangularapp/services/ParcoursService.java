package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.utilitaires.DefiEntityDto;
import be.technofuturtic.javaangularapp.utilitaires.ParcoursEntityDto;

import java.util.List;

public interface ParcoursService {
    List<ParcoursEntity> findAll();
    List<ParcoursEntity> findActive();
    void desactiverParcours(Integer idParcours);
    void activerParcours(Integer idParcours);
    Boolean ajouterParcours(ParcoursEntityDto nouveauParcours);
    void modifierDefiDansParcours(Integer idParcours, Integer idDefiARemplacer, DefiEntityDto nouveauDefi) throws Exception;
    void interchangerDefisDansParcours(Integer idParcours, Integer idDefiARemplacer, Integer idDefiAInserer) throws Exception;
    void supprimerDefiDansParcours(Integer idParcours, Integer idDefiASupprimer);
    void ajouterDefiDansParcours(Integer idParcours, DefiEntityDto nouveauDefi) throws Exception;
    Boolean ajouterDefiDansParcours(Integer idParcours, Integer idDefi) throws Exception;
    Boolean majParcours(Integer idParcours, ParcoursEntityDto parcoursDto);
    List<DefiEntity> listDefis(Integer idParcours);
}
