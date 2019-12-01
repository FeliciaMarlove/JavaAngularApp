package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.models.DefiEntity;

import java.util.List;

public interface CategorieService {
    List<CategorieEntity> findAll();
    void desactiverCategorie(Integer idCategorie);
    void activerCategorie(Integer idCategorie);
    void ajouterCategorie(CategorieEntity nouvelleCategorie);
    void majCategorie(Integer idCategorie, CategorieEntity categorie);
}
