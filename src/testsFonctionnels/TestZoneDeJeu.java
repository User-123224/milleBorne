package testsFonctionnels;

import carte.Borne;
import carte.DebutLimite;
import carte.Parade;
import carte.Type;
import jeu.Joueur;
import jeu.MainJoueur;
import jeu.ZoneDeJeu;

public class TestZoneDeJeu {
	public static void main(String[] args) {
		ZoneDeJeu zone = new ZoneDeJeu();
		MainJoueur main = new MainJoueur();
		Joueur joueur = new Joueur("Personne", zone, main);
		
		System.out.println(main.toString());
		joueur.donner(new Borne(50));
		System.out.println("Ajout d'une borne 50. " + main.toString());
		joueur.donner(new Parade(Type.FEU));
		joueur.donner(new Parade(Type.FEU));
		joueur.donner(new DebutLimite());
		System.out.println("Ajout d'un feu vert et d'une limitation. " + main.toString());
		joueur.deposer(new Parade(Type.FEU));
		joueur.getMain().jouer(new Parade(Type.FEU));
		System.out.println("Utilisation d'un feu vert. " + main.toString());
		System.out.println("Vous avez parcourus " + joueur.donnerKmParcourus() + "km.");
		joueur.deposer(new Borne(50));
		joueur.getMain().jouer(new Borne(50));
		System.out.println("Utilisation d'une borne 50. " + main.toString());
		System.out.println("Vous avez parcourus " + joueur.donnerKmParcourus() + "km.");
		joueur.deposer(new DebutLimite());
		System.out.println("Victime d'une limitation. " + main.toString());
		System.out.println("Vous êtes limités à " + zone.donnerLimitationVitesse() + "km.");
	}
}
