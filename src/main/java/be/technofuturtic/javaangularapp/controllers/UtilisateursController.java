package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.services.UtilisateurService;
import be.technofuturtic.javaangularapp.utilitaires.AuthentificationDto;
import be.technofuturtic.javaangularapp.utilitaires.UtilisateurEntityDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/utilisateurs", method = {RequestMethod.POST, RequestMethod.GET})
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
    public Boolean creerCompte(@RequestBody UtilisateurEntityDto utilisateur) {
        return this.service.creerCompte(utilisateur);
    }
    /* JSON format creerCompte
        {
           "nomUtilisateur" : "Derulo",
            "prenomUtilisateur" : "Jason",
            "dateNaiss" : "1988-04-07",
            "email" : "jason@msn.com",
            "motDePasse" : "1234",
            "newsletterOptIn" : true
        }
     */

    @PostMapping("/update/{id}") //HAS TO BE TESTED WHEN COUNTRY LIST IS LOADED !
    public void modifierUtilisateur(@RequestBody UtilisateurEntityDto utilisateur, @PathVariable("id") Long id) {
        this.service.majUtilisateur(utilisateur, id);
    }
    /*
    JSON
        {
            "motDePasse" : "sesame",
            "idPays" : 55,
            "email" : "emailupdate@msn.com"
        }
     */

    @PostMapping("/subscribe/{id}")
    public void inscrireNewsletter(@PathVariable("id") Long id) {
        this.service.inscrireNewsletter(id);
    }

    @PostMapping("/unsubscribe/{id}")
    public void desinscrireNewsletter(@PathVariable("id") Long id) {
        this.service.desinscrireNewsletter(id);
    }

    @PostMapping("/login")
    public Boolean login(@RequestBody AuthentificationDto logins) {
        return this.service.login(logins);
    }

    @GetMapping("/{email}")
    public UtilisateurEntityDto findByEmail(@PathVariable("email") String email) {
        return this.service.findByEmail(email);
    }
}
