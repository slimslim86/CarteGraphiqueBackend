package com.jeucarte.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeucarte.dao.CarteRepository;
import com.jeucarte.entity.Carte;

@Service
public class CarteServiceImpl implements CarteService {

	@Autowired
	private CarteRepository carteRepository;

	@Override
	public List<Carte> recupCartes() {	
		return carteRepository.findAll();
	}

	@Override
	public List<Carte> recupCartesMelanger() {
		List<Carte> cartes = carteRepository.findAll();
		Collections.shuffle(cartes);

		return cartes;
	}

	@Override
	public void ajoutCarte(Carte c) {	
		carteRepository.save(c);
	}

}
