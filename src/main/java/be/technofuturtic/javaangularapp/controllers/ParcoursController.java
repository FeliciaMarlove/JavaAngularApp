package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.models.ParcoursEntity;
import be.technofuturtic.javaangularapp.repositories.ParcoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/parcours")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ParcoursController {
    @Autowired
    private ParcoursRepository parcoursRepository;

    @GetMapping
    public List<ParcoursEntity> list() {
        return (List<ParcoursEntity>) parcoursRepository.findAll();
    }

}
