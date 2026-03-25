package testsFonctionnels;

import carte.Carte;
import carte.Type;
import carte.Borne;
import carte.Attaque;
import carte.Parade;

public class TestMethodeEquals {
	public static void main(String[] args) {
		Carte borne1 = new Borne(25);
		Carte borne2 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ? " + borne1.equals(borne2));

		Carte feuR1 = new Attaque(Type.FEU);
		Carte feuR2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feu rouge sont identiques ? " + feuR1.equals(feuR2));
		
		Carte feuV = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + feuR1.equals(feuV));
	}
}
