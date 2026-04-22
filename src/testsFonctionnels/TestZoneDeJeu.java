package testsFonctionnels;

import jeu.Joueur;
import jeu.MainJoueur;
import jeu.ZoneDeJeu;

public class TestZoneDeJeu {
	public static void main(String[] args) {
		ZoneDeJeu zone = new ZoneDeJeu();
		MainJoueur main = new MainJoueur();
		Joueur joueur = new Joueur("Personne", zone, main);
		
		System.out.println(main.toString());
	}
}
