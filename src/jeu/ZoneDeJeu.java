package jeu;

import java.util.ArrayList;
import java.util.List;

import carte.Attaque;
import carte.Borne;
import carte.Carte;
import carte.DebutLimite;
import carte.FinLimite;
import carte.Limite;
import carte.Parade;
import carte.Type;

public class ZoneDeJeu {
	private List<Carte> limites = new ArrayList<>();
	private List<Carte> batailles = new ArrayList<>();
	private List<Carte> bornes = new ArrayList<>();
	
	public int donnerLimitationVitesse() {
		if(limites.isEmpty() || limites.get(0).equals(new FinLimite())){//comment savoir si c'est une fin de limitation ?
			return 200;
		}
		return 50;
	}
	
	public int donnerKmParcourus() {
		int kmParcourus = 0;
		Borne borne25 = new Borne(25);
		Borne borne50 = new Borne(50);
		Borne borne75 = new Borne(75);
		Borne borne100 = new Borne(100);
		Borne borne200 = new Borne(200);
		for(int i = 0; i < bornes.size(); i++) {
			System.out.println("on a au moins une borne. ");
			if(bornes != null && bornes.get(i).equals(borne25)) {
				System.out.println("c'est une borne 25.");
				kmParcourus += 25;
			} else if(bornes != null && bornes.get(i).equals(borne50)) {
				System.out.println("c'est une borne 50.");
				kmParcourus += 50;
			} else if(bornes != null && bornes.get(i).equals(borne75)) {
				System.out.println("c'est une borne 75.");
				kmParcourus += 75;
			} else if(bornes != null && bornes.get(i).equals(borne100)) {
				System.out.println("c'est une borne 100.");
				kmParcourus += 100;
			} else if(bornes != null && bornes.get(i).equals(borne200)) {
				System.out.println("c'est une borne 200.");
				kmParcourus += 200;
			}
		}
		return kmParcourus;
	}
	
	public void deposer(Carte carte) {
		Limite finLimite = new FinLimite();
		Limite debutLimite = new DebutLimite();
		Borne borne25 = new Borne(25);
		Borne borne50 = new Borne(50);
		Borne borne75 = new Borne(75);
		Borne borne100 = new Borne(100);
		Borne borne200 = new Borne(200);
		if(carte != null && (carte.equals(borne25) || carte.equals(borne50) || carte.equals(borne75) || carte.equals(borne100) || carte.equals(borne200))) {
			bornes.add(carte);
		} else if(carte != null && (carte.equals(debutLimite) || carte.equals(finLimite))) {
			limites.add(carte);
		} else {
			batailles.add(carte);
		}
	}
	
	public boolean peutAvancer() {
		return !(batailles.isEmpty()) && batailles.get(0).equals(new Parade(Type.FEU));
	}
	
	public boolean estDepotFeuVertAutorise() {
		return !batailles.isEmpty()) && (batailles.get(0).equals(new Attaque(Type.FEU)) || !(batailles.get(0).equals(new Parade(Type.FEU))));
	}
}
