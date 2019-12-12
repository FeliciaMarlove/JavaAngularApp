package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.models.DefiEntity;

import java.util.List;

public interface CategorieService {
    List<CategorieEntity> findAll();
    void desactiverCategorie(Integer idCategorie);
    void activerCategorie(Integer idCategorie);
    Boolean ajouterCategorie(CategorieEntity nouvelleCategorie);
    Boolean majCategorie(Integer idCategorie, CategorieEntity categorie);
    List<CategorieEntity> findAllActifs();
}
