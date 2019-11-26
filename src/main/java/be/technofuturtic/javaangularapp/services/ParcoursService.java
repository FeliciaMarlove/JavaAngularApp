package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import java.util.List;

public interface ParcoursService {
    public List<ParcoursEntity> findAll();
    void desactiverParcours(Integer idParcours);
    void activerParcours(Integer idParcours);
    void ajouterParcours(ParcoursEntity nouveauParcours);
    void modifierDefiDansParcours(Integer idParcours, Integer idDefiARemplacer, DefiEntity nouveauDefi);
    void modifierDefiDansParcours(Integer idParcours, Integer idDefiARemplacer, Integer idDefiAAjouter);
    void ajouterDefiDansParcours(Integer idParcours, DefiEntity nouveauDefi);
    void commencerParcours(Integer idParcours);
}
