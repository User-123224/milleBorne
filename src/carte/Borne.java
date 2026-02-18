package carte;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.km = km;
	}
	@Override
	public String toString() {
		String carte = km + " km";
		return carte;
	}
}
