package testsFonctionnels;

import carte.JeuDeCartes;

public class TestJeuDeCartes {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println(jeu.afficherJeuDeCartes());
		
		System.out.println("On a le bon nombre de carte ? " + jeu.checkCount());
	}
}
