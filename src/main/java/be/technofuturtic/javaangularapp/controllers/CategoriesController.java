package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import be.technofuturtic.javaangularapp.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CategoriesController {
    private final CategorieService service;

    public CategoriesController(CategorieService service) {
        this.service = service;
    }

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping
    public List<CategorieEntity> list() {
        return (List<CategorieEntity>) categorieRepository.findAll();
    }

    @PostMapping
    public void creerCategorie(@RequestBody CategorieEntity categorie) {
        this.service.ajouterCategorie(categorie);
    }

}
