package pl.edu.pw.mini.zpoif.punktowane.chocolate.sweets;

public abstract class Sweets {
	private int mass;
	private double chocolateRatio;
	private int energy;

	public Sweets(int mass, double chocolateRatio, int energy) {
		this.mass = mass;
		this.energy = energy;
		this.chocolateRatio = chocolateRatio;
	}

	public int getMass() {
		return mass;
	}

	public double getChocolateRatio() {
		return chocolateRatio;
	}

	public int getEnergy() {
		return energy;
	}

}
