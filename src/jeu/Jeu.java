package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import carte.Carte;
import carte.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	
	public Jeu(){
		JeuDeCartes jeudecartes = new JeuDeCartes();
		Carte[] cartes = jeudecartes.donnerCartes();
		ArrayList<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, cartes);
		List<Carte> cartesMelangees = GestionCartes.melanger(listeCartes);
		
		this.sabot = new Sabot(cartesMelangees.toArray(new Carte[0]));
	}
}
