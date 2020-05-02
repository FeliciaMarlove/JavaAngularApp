/*
package be.technofuturtic.javaangularapp.controllers;

import be.technofuturtic.javaangularapp.config.JwtTokenUtil;
import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.services.UtilisateurService;
import be.technofuturtic.javaangularapp.utilitaires.AuthentificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.*;

@RestController
@CrossOrigin
public class AuthenticationController {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private UtilisateurService utilisateurService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UtilisateurService utilisateurService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginAction(@RequestBody()AuthentificationDto authentificationDto) throws Exception {
        authenticationManager.authenticate(authentificationDto.email, authentificationDto.password);
        UserDetails userDetails = utilisateurService.loadUserByUsername(authentificationDto.email);
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }
}
*/
