package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.PaiementEntity;
import be.technofuturtic.javaangularapp.repositories.PaiementRepository;
import be.technofuturtic.javaangularapp.services.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PaiementsController {
    private final PaiementService service;

    public PaiementsController(PaiementService service) {
        this.service = service;
    }

    @Autowired
    private PaiementRepository paiementsRepository;

    @GetMapping
    public List<PaiementEntity> list() {
        return (List<PaiementEntity>) paiementsRepository.findAll();
    }

    @PostMapping("/ajouter")
    public void ajouterPaiement(@RequestBody PaiementEntity paiementEntity) {
        this.service.ajouterPaiement(paiementEntity);
    }
    /*
    JSON
    {
	"nomPaiement" : "gratuit",
	"descPaiement" : "Parcours gratuit"
}
     */

    @PostMapping("/desactiver/{id}")
    public void desactiverPaiement(@PathVariable("id") Integer idPaiement) {
        this.service.desactiverPaiement(idPaiement);
    }

    @PostMapping("/activer/{id}")
    public void activerPaiement(@PathVariable("id") Integer idPaiement) {
        this.service.activerPaiement(idPaiement);
    }
}
