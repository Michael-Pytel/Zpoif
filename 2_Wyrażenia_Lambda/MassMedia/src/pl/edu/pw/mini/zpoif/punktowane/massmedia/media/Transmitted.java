package pl.edu.pw.mini.zpoif.punktowane.massmedia.media;

public abstract class Transmitted extends MassMedia {
	private int recievers;
	private int truthfullnessCoef;

	public Transmitted(String name, int reputation, int recievers, int truthfullnessCoef) {
		super(name, reputation);
		this.recievers = recievers;
		this.truthfullnessCoef = truthfullnessCoef;
	}

	public int getRecievers() {
		return recievers;
	}

	public int getTruthfullnessCoef() {
		return truthfullnessCoef;
	}



}
