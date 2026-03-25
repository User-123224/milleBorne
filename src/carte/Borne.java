package carte;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.km = km;
	}
	@Override
	public String toString() {
		return km + "KM";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne borne) {
			return this.km == borne.km;
		}
		return false;
	}
}
