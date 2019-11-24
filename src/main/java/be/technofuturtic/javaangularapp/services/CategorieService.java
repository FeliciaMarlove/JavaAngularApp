package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.CategorieEntity;

import java.util.List;

public interface CategorieService {
    List<CategorieEntity> findAll();
}
