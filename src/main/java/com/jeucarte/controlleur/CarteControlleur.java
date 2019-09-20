package com.jeucarte.controlleur;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeucarte.dao.CarteRepository;
import com.jeucarte.entity.Carte;
import com.jeucarte.service.CarteService;

@CrossOrigin("*")
@RestController
public class CarteControlleur {

	@Autowired
	private CarteService carteService;

	List<Carte> cartes;

	@PostConstruct
	void loadCartes() {
		cartes = new ArrayList<Carte>();
	}

	@GetMapping("/cartes")
	public List<Carte> consulterCartes() {
		cartes = carteService.recupCartes();
		return cartes;
	}

	@GetMapping("/cartes/melanger")
	public List<Carte> consulterCartesMelanger() {
		cartes = carteService.recupCartesMelanger();
		return cartes;
	}

	@GetMapping(path = "/photoCarte/{name}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable("name") String name) throws IOException {
		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/photoCarte/" + name));

	}

}
