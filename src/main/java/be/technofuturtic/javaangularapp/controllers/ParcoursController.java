package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.repositories.ParcoursRepository;
import be.technofuturtic.javaangularapp.services.ParcoursService;
import be.technofuturtic.javaangularapp.utilitaires.DefiEntityDto;
import be.technofuturtic.javaangularapp.utilitaires.ParcoursDefiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/ajouterDefi/{idparcours}")
    public void ajouterDefiDansParcours(
            @RequestBody DefiEntityDto defi,
            @PathVariable("idparcours") Integer idParcours) throws Exception {
        this.service.ajouterDefiDansParcours(idParcours, defi);
    }

    @PostMapping("/supprimerdefi/{idparcours}")
    public void supprimerDefiDansParcours(
            @RequestBody ParcoursDefiDto a,
            @PathVariable("idparcours") Integer idParcours) {
        this.service.supprimerDefiDansParcours(
                idParcours,
                a.getDefiRmv()
        );
    }

    @PostMapping("/modifier/{idparcours}")
    public void modifierDefiDansParcours(
            @RequestBody ParcoursDefiDto a,
            @PathVariable("idparcours") Integer idParcours) throws Exception {
        this.service.modifierDefiDansParcours(
                idParcours,
                a.getDefiRmv(),
                new DefiEntityDto(a.getNomDefi(), a.getDescDefi(), a.getInfobulleDefi(), a.getCategorieId())
        );
    }

    /*
    Json test
    {
		"defiRmv" : 41,
        "nomDefi" : "truc",
        "descDefi" : "jfdslkfjls",
        "infobulleDefi" : "jfdksjfljsdkf",
        "categorieId" : 99
    }
     */

    //-------------------------------------------


}
