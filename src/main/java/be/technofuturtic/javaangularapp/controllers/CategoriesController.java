package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import be.technofuturtic.javaangularapp.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", method = {RequestMethod.POST, RequestMethod.GET})
@CrossOrigin(origins = {"http://localhost:4200"})
public class CategoriesController {
    private final CategorieService service;

    public CategoriesController(CategorieService service) {
        this.service = service;
    }

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/all")
    public List<CategorieEntity> list() {
        return (List<CategorieEntity>) categorieRepository.findAll();
    }

    @GetMapping
    public List<CategorieEntity> listActive() { return this.service.findAllActifs(); }

    @PostMapping("/desactiver/{id}")
    public void desactiverCategorie(@PathVariable("id") Integer idCategorie) {
        this.service.desactiverCategorie(idCategorie);
    }

    @GetMapping("/activer/{id}")
    public void activerCategorie(@PathVariable("id") Integer idCategorie) {
        this.service.activerCategorie(idCategorie);
    }

    @PostMapping("/update/{id}")
    public Boolean modifierCategorie(@RequestBody CategorieEntity categorie, @PathVariable("id") Integer id) {
        return this.service.majCategorie(id, categorie);
    }

    @PostMapping("/creer")
    public Boolean creerCategorie(@RequestBody CategorieEntity categorie) {
        return this.service.ajouterCategorie(categorie);
    }
    /*
    JSON test
        {
            "nomCategorie" : "Loisirs",
            "descCategorie" : "Description de loisirs"
        }
     */
}
