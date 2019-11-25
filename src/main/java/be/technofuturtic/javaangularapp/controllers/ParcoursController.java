package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.repositories.ParcoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/parcours")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ParcoursController {
    @Autowired
    private ParcoursRepository parcoursRepository;

    @GetMapping
    public List<ParcoursEntity> list() {
        return (List<ParcoursEntity>) parcoursRepository.findAll();
    }

    @GetMapping("/{id}")
    public Set<DefiEntity> get(@PathVariable("id") Integer idParcours) {
        /*DefiEntity a = new DefiEntity();
        a.setActiveDefi(true);
        a.setDescDefi("Defi bidon 2");
        a.setInfobulleDefi("Infobulle defi bidon 2");
        a.setNomDefi("Defi B2");
        parcoursRepository.findById(99).get().getListeDefis().add(a);*/
        return parcoursRepository.findById(idParcours).get().getListeDefis();
    }
}
