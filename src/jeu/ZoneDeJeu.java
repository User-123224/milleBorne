package jeu;

import java.util.ArrayList;
import java.util.List;

import carte.Carte;
import carte.FinLimite;

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
		for(int i = 0; i < bornes.size(); i++) {
			kmParcourus = kmParcourus + bornes.get(i);//obtenir le km sans get ?
		}
	}
}
