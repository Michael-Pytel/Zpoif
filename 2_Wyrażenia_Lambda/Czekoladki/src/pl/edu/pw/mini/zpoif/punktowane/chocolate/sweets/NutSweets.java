package pl.edu.pw.mini.zpoif.punktowane.chocolate.sweets;

public abstract class NutSweets extends Sweets {

	private Boolean containsNuts;

	public NutSweets(int mass, int chocolateRatio, int energy, Boolean containsNuts) {
		super(mass, chocolateRatio, energy);
		this.containsNuts = containsNuts;
		// TODO Auto-generated constructor stub
	}

}
