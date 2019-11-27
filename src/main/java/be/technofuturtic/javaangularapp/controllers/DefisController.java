package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.repositories.DefiRepository;
import be.technofuturtic.javaangularapp.services.DefiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/defis")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DefisController {
    private final DefiService service;

    @Autowired
    private DefiRepository defiRepository;

    public DefisController(DefiService service) {
        this.service = service;
    }

    @GetMapping
    public List<DefiEntity> list() {
        return (List<DefiEntity>) defiRepository.findAll();
    }

    @GetMapping("/{id}")
    public DefiEntity getOne(@PathVariable("id") Integer idDefi) {
        return defiRepository.findByIdDefi(idDefi);
    }

    @PostMapping("/desactiver/{id}")
    public void desactUtil(@RequestBody DefiEntity utilisateur, @PathVariable("id") Integer idDefi) {
        this.service.desactiverDefi(idDefi);
    }

    @PostMapping("/activer/{id}")
    public void actUtil(@RequestBody DefiEntity utilisateur, @PathVariable("id") Integer idDefi) {
        this.service.activerDefi(idDefi);
    }

    @PostMapping("/creer")
    public void creerDefi(@RequestBody DefiEntity defi) {
        this.service.creerDefi(defi);
    }
}
