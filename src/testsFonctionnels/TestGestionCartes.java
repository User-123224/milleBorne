package testsFonctionnels;

import java.util.ArrayList;
import java.util.Collections;

import carte.Carte;
import carte.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		ArrayList<Carte> listeCarteNonMelangee = new ArrayList<>();
		//for (Carte carte : jeu.donnerCartes()) {
		//	listeCarteNonMelangee.add(carte);
		//}
		Collections.addAll(listeCarteNonMelangee, jeu.donnerCartes());
		ArrayList<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = (ArrayList<Carte>) GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "
		+ GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = GestionCartes.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? "
		+ GestionCartes.verifierRassemblement(listeCartes));
	}
}
