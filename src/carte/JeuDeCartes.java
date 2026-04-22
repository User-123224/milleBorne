package carte;

public class JeuDeCartes {
	private Configuration[] config = { new Configuration(new Borne(25), 10), new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10), new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4), new Configuration(new Parade(Type.FEU), 14),
			new Configuration(new FinLimite(), 6), new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6), new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new Attaque(Type.FEU), 5), new Configuration(new DebutLimite(), 4),
			new Configuration(new Attaque(Type.ESSENCE), 3), new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ACCIDENT), 3), new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE), 1), new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Botte(Type.ACCIDENT), 1), };

	private static class Configuration {
		private int nbExemplaires;
		private Carte carte;

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
		StringBuilder jeu = new StringBuilder("JEU :\n");
		for (int i = 0; i < config.length; i++) {
			jeu.append(Integer.toString(config[i].getNbExemplaires()));
			jeu.append(" ");
			jeu.append(config[i].getCarte());
			jeu.append("\n");
		}
		return jeu.toString();
	}

	public Carte[] donnerCartes() {
		int nbCarteTotal = 0;
		for (Configuration c : config) {
			nbCarteTotal += c.getNbExemplaires();
		}
		Carte[] cartes = new Carte[nbCarteTotal];
		for (int i = 0, index = 0; i < config.length; i++) {
			for (int j = 0; j < config[i].getNbExemplaires(); j++) {
				cartes[index] = config[i].getCarte();
				index++;
			}
		}
		return cartes;
	}

	public boolean checkCount() {
		Carte[] cartesAVerifier = donnerCartes();
		int[] compte = new int[config.length];
		for (int i = 0; i < config.length; i++) {
			int j = 0;
			for (; j < cartesAVerifier.length; j++) {
				if (cartesAVerifier[j].equals(config[i].getCarte())) {
					compte[i]++;
				}
			}
		}
		for (int i = 0; i < config.length; i++) {
			if (compte[i] != config[i].getNbExemplaires()) {
				return false;
			}
		}
		return true;
	}
}

//CORRECTION :
//voir dans checkCount, pourquoi on a "int j = 0;" hors de la boucle ?

//10 Borne 25			6 Roue de secours		1 Citerne
//10 Borne 50			6 Réparation			1 Increvable
//10 Borne 75			5 Feu rouge				1 As du volant
//12 Borne 100			4 Limite 50
// 4 Borne 200			3 Panne d'essence
//14 Feu vert			3 Crevaison
// 6 Fin de limite		3 Accident
// 6 Essence			1 Prioritaire
