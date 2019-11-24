package be.technofuturtic.javaangularapp;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import be.technofuturtic.javaangularapp.services.CategorieServiceImplemented;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class JavaangularappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaangularappApplication.class, args);
	}
}
