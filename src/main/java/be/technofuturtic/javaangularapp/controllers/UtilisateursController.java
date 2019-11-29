package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.services.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UtilisateursController {
     private final UtilisateurService service;

    public UtilisateursController(UtilisateurService service) {
        this.service = service;
    }

    @GetMapping
    public List<UtilisateurEntity> list() {
        return service.findAll();
    }

    @PostMapping("/desactiver/{id}")
    public void desactUtil(@RequestBody UtilisateurEntity utilisateur, @PathVariable("id") Long idUtilisateur) {
        this.service.desactiverUtilisateur(idUtilisateur);
    }

    @PostMapping("/activer/{id}")
    public void actUtil(@RequestBody UtilisateurEntity utilisateur, @PathVariable("id") Long idUtilisateur) {
        this.service.activerUtilisateur(idUtilisateur);
    }

    @PostMapping("/creer")
    public void creerCompte(@RequestBody UtilisateurEntity utilisateur) {
        this.service.creerCompte(utilisateur);
    }
    /* JSON format creerCompte
    	{
            "nomUtilisateur" : "jflkdfj",
            "prenomUtilisateur" : "jkfdjfk",
            "dateNaiss" : "1988-04-07",
            "email" : "jfdklfjdlk@msn.com",
            "motDePasse" : "1234",
            "newsletterOptIn" : true
        }
     */
}
