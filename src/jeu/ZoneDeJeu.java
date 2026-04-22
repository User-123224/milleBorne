package jeu;

import java.util.ArrayList;
import java.util.List;

import carte.Borne;
import carte.Carte;
import carte.FinLimite;
import carte.Limite;
import carte.Probleme;
import carte.Type;

public class ZoneDeJeu {
	private List<Carte> limites = new ArrayList<>();
	private List<Carte> batailles = new ArrayList<>();
	private List<Carte> bornes = new ArrayList<>();
	
	public int donnerLimitationVitesse() {
		if(limites.isEmpty() || limites.get(limites.size()).equals(new FinLimite())){//comment savoir si c'est une fin de limitation ?
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
			if(bornes != null && bornes.get(i).equals(borne25)) {
				kmParcourus += 25;
			} else if(bornes != null && bornes.get(i).equals(borne50)) {
				kmParcourus += 50;
			} else if(bornes != null && bornes.get(i).equals(borne75)) {
				kmParcourus += 75;
			} else if(bornes != null && bornes.get(i).equals(borne100)) {
				kmParcourus += 100;
			} else if(bornes != null && bornes.get(i).equals(borne200)) {
				kmParcourus += 200;
			}
		}
		return kmParcourus;
	}
	
	public void deposer(Carte carte) {
		Limite limite = new FinLimite();
		Borne borne = new Borne(25);
		if(carte != null && carte.equals(borne)) {
			bornes.add(carte);
		} else if(carte != null && carte.equals(limite)) {
			limites.add(carte);
		} else {
			batailles.add(carte);
		}
	}
}
