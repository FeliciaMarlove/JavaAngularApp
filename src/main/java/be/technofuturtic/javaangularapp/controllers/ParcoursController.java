package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.repositories.ParcoursRepository;
import be.technofuturtic.javaangularapp.services.ParcoursService;
import be.technofuturtic.javaangularapp.utilitaires.DefiEntityDto;
import be.technofuturtic.javaangularapp.utilitaires.ParcoursDefiDto;
import be.technofuturtic.javaangularapp.utilitaires.ParcoursEntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/parcours", method = {RequestMethod.POST, RequestMethod.GET})
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
    public void desactParc(@PathVariable("id") Integer idParcours) {
        this.service.desactiverParcours(idParcours);
    }

    @PostMapping("/activer/{id}")
    public void actParc(@PathVariable("id") Integer idParcours) {
        this.service.activerParcours(idParcours);
    }

    @PostMapping("/creer")
    public void ajouterParcours(@RequestBody ParcoursEntityDto nouveauParcours) {
        this.service.ajouterParcours(nouveauParcours);
    }
    /*
    JSON
    {
        "nomParcours" : "Parcours 2",
        "descParcours" : "Deuxième parcours",
        "prix" : 0.00,
        "categorie" : 99
    }
     */

    @PostMapping("/ajouterDefi/{idparcours}")
    public void ajouterDefiDansParcours(
            @RequestBody DefiEntityDto defi,
            @PathVariable("idparcours") Integer idParcours) throws Exception {
        this.service.ajouterDefiDansParcours(idParcours, defi);
    }
    /* JSON
    {
        "nomDefi" : "Defi Defi",
        "descDefi" : "Un défi parmi tant d'autres",
        "infobulleDefi" : "Shalalalalalala",
        "categorieId" : 99
    }
     */

    @PostMapping("/supprimerdefi/{idparcours}/{iddefi}")
    public void supprimerDefiDansParcours(@PathVariable("idparcours") Integer idParcours,
                                          @PathVariable("iddefi") Integer idDefi) {
        this.service.supprimerDefiDansParcours(
                idParcours,
                idDefi
        );
    }
    //ex : http://localhost:8080/api/parcours/supprimerdefi/99/64

    @PostMapping("/update/{id}")
    public void updateParcours(@RequestBody ParcoursEntityDto parcours, @PathVariable("id") Integer idParcoursToUpdate) {
        this.service.majParcours(idParcoursToUpdate, parcours);
    }
    /*JSON
        {
            "nomParcours" : "Premier parcours",
            "descParcours" : "Premier parcours modifie",
            "prix" : 50.00,
            "idCategorie" : 69
        }
     */

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

    @PostMapping("/modifier/{idparcours}/{iddefiout}/{iddefiin}")
    public void modifierDefiDansParcours(@PathVariable("idparcours") Integer idParcours,
                                         @PathVariable("iddefiout") Integer idDefiOut,
                                         @PathVariable("iddefiin") Integer idDefiIn) throws Exception {
        this.service.interchangerDefisDansParcours(
                idParcours,
                idDefiOut,
                idDefiIn);
    }
    // ex : http://localhost:8080/api/parcours/modifier/99/41/101
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
}
