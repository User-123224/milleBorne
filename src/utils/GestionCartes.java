package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class GestionCartes {
	private static Random rand = new Random();
	
	private GestionCartes() {
		  /* This utility class should not be instantiated */
	}

	
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
	
	public static <E> List<E> melanger(ArrayList<E> liste) {
		ArrayList<E> nouvelleListe = new ArrayList<>();
		while(!liste.isEmpty()) {
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

	public static <E> ArrayList<E> rassembler(ArrayList<E> liste){
		int nbElement = countElement(liste);
		ArrayList<E> listeConsecutifs = new ArrayList<>();
		for(int i = 0; i < nbElement; i++) {
			if(!listeConsecutifs.contains(liste.get(i))) {
				listeConsecutifs.add(liste.get(i));
				for(int j = i+1; j < nbElement; j++) {
					if(liste.get(i).equals(liste.get(j))) {
						listeConsecutifs.add(liste.get(j));
					}
				}
			}
		}
		return listeConsecutifs;
	}
	
	public static <E> boolean verifierRassemblement(ArrayList<E> liste) {
		for(ListIterator<E> iterateur1 = liste.listIterator(); iterateur1.hasNext(); ) {
			E suivant = iterateur1.next();
			if(iterateur1.hasNext() && !suivant.equals(liste.get(iterateur1.nextIndex()))) {
				for(ListIterator<E> iterateur2 = liste.listIterator(iterateur1.nextIndex()); iterateur2.hasNext(); ) {
					if(iterateur2.hasNext() && suivant.equals(iterateur2.next())) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
