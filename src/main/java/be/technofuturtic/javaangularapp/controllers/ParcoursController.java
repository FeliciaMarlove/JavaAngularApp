package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.repositories.ParcoursRepository;
import be.technofuturtic.javaangularapp.services.ParcoursService;
import be.technofuturtic.javaangularapp.utilitaires.ModifierDefiDansParcoursUtil;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/parcours")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ParcoursController {
    private final ParcoursService service;

    public ParcoursController(ParcoursService service) {
        this.service = service;
    }

    @Autowired
    private ParcoursRepository parcoursRepository;

    @GetMapping
    public List<ParcoursEntity> list() {
        return (List<ParcoursEntity>) parcoursRepository.findAll();
    }

    @PostMapping
    public void modifierDefiDansParcours(@RequestBody ModifierDefiDansParcoursUtil a){
        this.service.modifierDefiDansParcours(
                a.getIdParcours(),
                a.getIdDefi(),
                new DefiEntity(a.getNomDefi(), a.getDescDefi(), a.getInfobulleDefi(), a.getCategorie())
        );
    }

}
