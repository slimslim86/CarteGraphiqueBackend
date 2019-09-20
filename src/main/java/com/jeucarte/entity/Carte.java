package com.jeucarte.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.test.jeucarte.Couleur;

@Entity
public class Carte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String rang;

	@Enumerated(EnumType.STRING)
	private Couleur couleur;

	public Carte() {
	}

	public Carte(String rang, Couleur couleur) {
		this.rang = rang;
		this.couleur = couleur;
	}

	public String getRang() {
		return this.rang;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	public void setRang(String rang) {

		this.rang = rang;
	}

	@Override
	public String toString() {
		return this.rang + " de " + this.couleur;
	}

}
