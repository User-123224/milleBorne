package carte;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.km = km;
	}
	@Override
	public String toString() {
		String carte = km + "KM";
		return carte;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne borne) {
			return this.km == borne.km;
		}
		return false;
	}
}
