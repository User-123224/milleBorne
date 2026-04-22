package jeu;

import carte.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zone;
	private MainJoueur main;
	
	public Joueur(String nom, ZoneDeJeu zone, MainJoueur main) {
		this.nom = nom;
		this.zone = zone;
		this.main = main;
	}
	
	public MainJoueur getMain() {
		return main;
	}

	public void setMain(MainJoueur main) {
		this.main = main;
	}

	public boolean equals(Object obj) {
		if(obj instanceof Joueur joueur) {
			return this.nom == joueur.nom;
		}
		return false;
	}
	
	public String toString() {
		return nom;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		main.prendre(carte);
		return carte;
	}
}
