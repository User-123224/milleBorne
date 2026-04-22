package jeu;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import carte.Carte;

public class MainJoueur implements Iterable<Carte>{
	List<Carte> main = new ArrayList<>();
	private int nbModif = 0;
	
	private class Iterateur implements Iterator<Carte> {
		private int index = 0;
		private boolean nextEffectue = false;
		private int nbModifAttendu = nbModif;

		public carte.Carte next() { 
			verifierConcurrence();
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			nextEffectue = true;
			return main.get(index++);
		}

		private void verifierConcurrence() {
			if (nbModif != nbModifAttendu) {
				throw new ConcurrentModificationException();
			}
		}
		
		public boolean hasNext() {
			return index < main.size();
		}
		
		@Override
		public void remove() {
			if(!nextEffectue) {
				throw new IllegalStateException();
			} 
			verifierConcurrence();
			for(int i = index-1; i < main.size()-1; i++) {
				main.set(i, main.get(i+1));
			}
			main.set(main.size()-1, null);
			main.remove(main.size()-1);
			index--;
			nextEffectue = false;
			nbModif++;
			nbModifAttendu++;
		}
	}
	
	public void prendre(Carte carte) {
		main.add(carte);
	}
	
	public void jouer(Carte carte) {
		assert main.contains(carte);
		main.remove(carte);
	}
	
	@Override
	public Iterator<Carte> iterator(){
		return new Iterateur();
	}
	
	public String toString() {
		StringBuilder afficheMain = new StringBuilder("La main est composé de : ");
		Iterator<Carte> iterateur = iterator();
		while(iterateur.hasNext()) {
			Carte carteCourante = iterateur.next();
			afficheMain.append(" - ");
			afficheMain.append(carteCourante);
			afficheMain.append("\n");
		}
		return afficheMain.toString();
	}
}
