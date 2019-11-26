package be.technofuturtic.javaangularapp;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.models.RoleEntity;
import be.technofuturtic.javaangularapp.models.UtilisateurEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import be.technofuturtic.javaangularapp.repositories.UtilisateurRepository;
import be.technofuturtic.javaangularapp.services.CategorieServiceImplemented;
import be.technofuturtic.javaangularapp.services.UtilisateurServiceImplemented;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class JavaangularappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaangularappApplication.class, args);


	}
}
