package com.jeucarte.service;

import java.util.List;

import com.jeucarte.entity.Carte;

public interface CarteService {

	public List<Carte> recupCartes();

	public List<Carte> recupCartesMelanger();

	public void ajoutCarte(Carte c);
}
