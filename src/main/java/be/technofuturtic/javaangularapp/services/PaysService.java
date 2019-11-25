package be.technofuturtic.javaangularapp.services;

import be.technofuturtic.javaangularapp.models.PaysEntity;

import java.util.List;

public interface PaysService {
    public List<PaysEntity> findAll();
}
