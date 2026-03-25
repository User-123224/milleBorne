package carte;

public abstract class Carte {
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		return getClass() == obj.getClass();
	}
}
