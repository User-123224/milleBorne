package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;


public class GestionCartes {
	private static Random rand = new Random();
	
//	public static <E> E extraire(E[] liste) {
//		int indiceAleatoire = rand.nextInt(0, liste.length);
//		E elementAleatoire = liste[indiceAleatoire];
//		for(int i = indiceAleatoire-1; i < liste.length-1; i++) {
//			liste[i] = liste[i+1];
//		}
//		return elementAleatoire;
//	}
	
	public static <E> E extraire(ArrayList<E> liste) {
		int indiceAleatoire = rand.nextInt(0, countElement(liste));
		E elementAleatoire = liste.get(indiceAleatoire);
		liste.remove(indiceAleatoire);
		return elementAleatoire;
	}

private static <E> int countElement(ArrayList<E> liste) {
	int nbElement = 0;
	for(Iterator<E> it = liste.iterator(); it.hasNext(); ) {
		nbElement++;
		it.next();
	}
	return nbElement;
}
	
	public static <E> ArrayList<E> melanger(ArrayList<E> liste) {
		ArrayList<E> nouvelleListe = new ArrayList<>();
		for(int i = 0; i < countElement(liste); i++) {
			nouvelleListe.add(extraire(liste));
		}
		return nouvelleListe;
	}
	
	public static <E> boolean verifierMelange(ArrayList<E> liste, ArrayList<E> listeMelange) {
		int nbElement = countElement(liste);
		if(nbElement != countElement(listeMelange)) {
			throw new IllegalStateException();
		}
		ArrayList<Integer> compte = new ArrayList<>();
		for(int i = 0; i < nbElement; i++) {
			if(!compte.contains(liste.get(i))) {
				compte.add(Collections.frequency(listeMelange, liste.get(i)));
			}
		}
		return true;
	}
}
