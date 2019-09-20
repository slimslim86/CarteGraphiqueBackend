package com.jeucarte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jeucarte.entity.Carte;
import com.jeucarte.service.CarteService;

import fr.test.jeucarte.Paquet52;

@SpringBootApplication
public class JeuCarteApplication implements CommandLineRunner {

	@Autowired
	private CarteService carteService;

	public static void main(String[] args) {
		SpringApplication.run(JeuCarteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Paquet52 c = new Paquet52();
		c.initPaquet();

		for (fr.test.jeucarte.Carte carte : c.getCartes()) {
			carteService.ajoutCarte(new Carte(carte.getRang(), carte.getCouleur()));
		}

	}

}
