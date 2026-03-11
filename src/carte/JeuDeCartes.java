package carte;

public class JeuDeCartes {
	
	private class Configuration{
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
	private Configuration[] config = {
			new Configuration(new Borne(25),10),
			new Configuration(new Borne(50),10),
			new Configuration(new Borne(75),10),
			new Configuration(new Borne(100),12),
			new Configuration(new Borne(200),4),
			new Configuration(new Parade(Type.FEU),14),
			new Configuration(new FinLimite(),6),
			new Configuration(new Parade(Type.ESSENCE),6),
			new Configuration(new Parade(Type.CREVAISON),6),
			new Configuration(new Parade(Type.ACCIDENT),6),
			new Configuration(new Attaque(Type.FEU),5),
			new Configuration(new DebutLimite(),4),
			new Configuration(new Attaque(Type.ESSENCE),3),
			new Configuration(new Attaque(Type.CREVAISON),3),
			new Configuration(new Attaque(Type.ACCIDENT),3),
			new Configuration(new Botte(Type.FEU),1),
			new Configuration(new Botte(Type.ESSENCE),1),
			new Configuration(new Botte(Type.CREVAISON),1),
			new Configuration(new Botte(Type.ACCIDENT),1),
	};
	
	
	public String afficherJeuDeCartes() {
		StringBuilder jeu = new StringBuilder("JEU :\n");
		int nbTypeCarte = 0;
		for(Configuration c : config) {
			nbTypeCarte++;
		}
		for(int i = 0; i < nbTypeCarte; i++) {
			jeu.append(Integer.toString(config[i].getNbExemplaires()));
			jeu.append(" ");
			jeu.append(config[i].getCarte().toString());
			jeu.append("\n");
		}
		return jeu.toString();
	}
	
	public Carte[] donnerCartes() {
		int nbTypeCarte = 0;
		int nbCarteTotal = 0;
		for(Configuration c : config ) {
			nbTypeCarte++;
			nbCarteTotal += c.getNbExemplaires();
		}
		Carte[] cartes = new Carte[nbCarteTotal];
		int index = 0;
		for(int i = 0; i < nbTypeCarte; i++) {
			for(int j = 0; j < config[i].getNbExemplaires(); j++) {
				cartes[index] = config[i].getCarte();
				index++;
			}
		}
		return cartes;
	}
}

//Borne 25			Roue de secours		Citerne
//Borne 50			Réparation			Increvable
//Borne 75			Feu rouge			As du volant
//Borne 100			Limite 50
//Borne 200			Panne d'essence
//Feu vert			Crevaison
//Fin de limite		Accident
//Essence			Prioritaire