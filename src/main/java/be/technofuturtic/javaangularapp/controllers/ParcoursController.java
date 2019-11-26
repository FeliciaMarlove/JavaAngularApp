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

    // return => ce qui est affiché en localhost8080/api/pacours

    /*@GetMapping
    public List<ParcoursEntity> list() {

        return (List<ParcoursEntity>) parcoursRepository.findAll();
    }*/

    @GetMapping
    public List<DefiEntity> List() {


    return parcoursRepository.findById(99).get().getListeDefis();
    }

    @PostMapping
    public void ajouterDefiDansParcours(@RequestBody DefiEntity d) {
        this.service.ajouterDefiDansParcours(99, d);
    }

    /*@PostMapping
    public void modifierDefiDansParcours(@RequestBody ModifierDefiDansParcoursUtil a){
        this.service.modifierDefiDansParcours(
                a.getIdParcours(),
                a.getIdDefi(),
                new DefiEntity(a.getNomDefi(), a.getDescDefi(), a.getInfobulleDefi(), a.getCategorie())
        );
    }*/
    /*
    JSON structure
    {
	"idParcours" : 99,
	"idDefi" : 99,
    "nomDefi" : "Defi bidon 2",
    "descDefi" : "Ajouté par Post",
    "infobulleDefi" : "Bla bla bla bla",
    "categorie" : 99
     */

}
