package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.PaiementEntity;

import java.util.List;

public interface PaiementService {
    public List<PaiementEntity> findAll();
}
