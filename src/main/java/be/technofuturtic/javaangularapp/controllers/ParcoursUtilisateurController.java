package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursUtilisateurLiaison;
import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.repositories.UtilisateurRepository;
import be.technofuturtic.javaangularapp.services.ParcoursService;
import be.technofuturtic.javaangularapp.services.ParcoursUtilisateurLiaisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/utilparc", method = {RequestMethod.POST, RequestMethod.GET})
@CrossOrigin(origins = {"http://localhost:4200"})
public class ParcoursUtilisateurController {
    private final ParcoursUtilisateurLiaisonService service;

    public ParcoursUtilisateurController(ParcoursUtilisateurLiaisonService service) {
        this.service = service;
    }

    @Autowired
    private UtilisateurRepository repoUtil;

    @GetMapping
    public List<ParcoursUtilisateurLiaison> list() {
        return service.findAll();
    }

    @PostMapping("/start/{idutil}/{idparcours}")
    public void commencerParcours(@PathVariable("idutil") Long idUtillisateur,
                                  @PathVariable("idparcours") Integer idParcours) {
        this.service.commencerParcours(idParcours, idUtillisateur);
    }

    @PostMapping("/defi/{idutil}")
    public void voirDefiDuJour(@PathVariable("idutil") Long idUtil) {
        this.service.voirDefiDuJour(idUtil);
    }
}
