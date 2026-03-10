package testsFonctionnels;

//import carte.Botte;
import carte.Carte;
import carte.JeuDeCartes;
//import carte.Type;
import jeu.Sabot;
import java.util.Iterator;

public class TestSabot {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		Sabot sabot1 = new Sabot(jeu.donnerCartes());
		while(!sabot1.estVide()) {
			System.out.println("Je pioche " + sabot1.piocher().toString());
		}
		System.out.println("Le sabot 1 est vide ? " + sabot1.estVide());
		

		Sabot sabot2 = new Sabot(jeu.donnerCartes());
		Iterator<Carte> iterateur = sabot2.iterator();
		//sabot2.piocher();
		while(!sabot2.estVide()) {
			//sabot2.ajouterCarte(new Botte(Type.ACCIDENT));
			Carte carteRetourne = iterateur.next();
			System.out.println("Je pioche " + carteRetourne.toString());
			iterateur.remove();
			//sabot2.piocher();
		}
		//System.out.println("Le sabot 2 est vide ? " + sabot2.estVide());
	}
}
