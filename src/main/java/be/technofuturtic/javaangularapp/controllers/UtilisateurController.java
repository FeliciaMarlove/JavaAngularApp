package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.services.UtilisateurService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UtilisateurController {
     private final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @PostMapping
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
