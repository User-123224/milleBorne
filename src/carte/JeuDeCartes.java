package carte;

public class JeuDeCartes {
	private class Configuration{
		private int nbExemplaires;
		private Carte carte = new Carte();

		private Configuration(Carte carte, int nbExemplaires) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}
	}
	
	
	public String afficherJeuDeCartes() {
		System.out.println("JEU :");
		for(int i = 0; i < 19; i++) {
			System.out.println();
		}
	}
}
