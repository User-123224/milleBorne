package carte;

public enum Type {
	FEU("Feu Rouge","Feu Vert","Prioritaire"),
	ESSENCE("Panne d'essence","Essence","Citerne"),
	CREVAISON("Crevaison","Roue de secours","Increvable"),
	ACCIDENT("Accident","Reparation","As du volant");
	
	private String accident;
	private String parade;
	private String botte;
	private Type(String accident, String parade, String botte) {
		this.accident = accident;
		this.parade = parade;
		this.botte = botte;
	}
	public String getAccident() {
		return accident;
	}
	public String getParade() {
		return parade;
	}
	public String getBotte() {
		return botte;
	}
}
