package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.repositories.ParcoursRepository;
import be.technofuturtic.javaangularapp.services.ParcoursService;
import be.technofuturtic.javaangularapp.utilitaires.ModifierDefiDansParcoursUtil;
import be.technofuturtic.javaangularapp.utilitaires.ModifierDefiDansParcoursUtilId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

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

    // return => ce qui est affiché en localhost8080/api/parcours(/...)

    @GetMapping
    public List<ParcoursEntity> getAll() {
        return (List<ParcoursEntity>) parcoursRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ParcoursEntity> getOne(@PathVariable("id") Integer idParcours) {
        return parcoursRepository.findById(idParcours);
    }

    @PostMapping("/desactiver/{id}")
    public void desactParc(@RequestBody ParcoursEntity parcours, @PathVariable("id") Integer idParcours) {
        this.service.desactiverParcours(idParcours);
    }

    @PostMapping("/activer/{id}")
    public void actParc(@RequestBody ParcoursEntity parcours, @PathVariable("id") Integer idParcours) {
        this.service.activerParcours(idParcours);
    }

    @PostMapping("/ajouter")
    public void ajouterParcours(@RequestBody ParcoursEntity nouveauParcours) {
        this.service.ajouterParcours(nouveauParcours);
    }

    @PostMapping("/modifier") //TO BE VERIFIED
    public void modifierDefiDansParcours(@RequestBody ModifierDefiDansParcoursUtil a){
        this.service.modifierDefiDansParcours(
                a.getIdParcours(),
                a.getIdDefi(),
                new DefiEntity(a.getNomDefi(), a.getDescDefi(), a.getInfobulleDefi(), a.getCategorie())
        );
    }
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

    @PostMapping("/modifier/{id}") //TO BE VERIFIED
    public void modifierDefiDansParcoursId(@RequestBody ModifierDefiDansParcoursUtilId a) {
        this.service.modifierDefiDansParcours(
                a.getIdParcours(),
                a.getIdDefiRemplace(),
                a.getIdDefiRemplacant()
        );
    }

    @PostMapping("/ajouterDefi/{idparcours}") //TO BE VERIFIED
    public void ajouterDefiDansParcours(
            @RequestBody DefiEntity defi,
            @PathVariable("idparcours") Integer idParcours) {
        this.service.ajouterDefiDansParcours(idParcours, defi);
    }
}
