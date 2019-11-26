package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.models.DefiEntity;
import be.technofuturtic.javaangularapp.repositories.DefiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/defis")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DefisController {
    @Autowired
    private DefiRepository defiRepository;

    @GetMapping
    public List<DefiEntity> list() {
        return (List<DefiEntity>) defiRepository.findAll();
    }

    @GetMapping("/{id}")
    public DefiEntity get(@PathVariable("id") Integer idDefi) {
        return defiRepository.findByIdDefi(idDefi);
    }


}
