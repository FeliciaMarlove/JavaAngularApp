package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.ParcoursEntity;

import java.util.List;

public interface ParcoursService {
    public List<ParcoursEntity> findAll();
}
