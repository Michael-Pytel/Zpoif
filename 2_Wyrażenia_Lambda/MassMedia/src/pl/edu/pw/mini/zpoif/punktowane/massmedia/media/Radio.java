package pl.edu.pw.mini.zpoif.punktowane.massmedia.media;

public class Radio extends Transmitted {

	public Radio(String name, int reputation, int recievers, int truthfullnessCoef) {
		super(name, reputation, recievers, truthfullnessCoef);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Radio [getName()=" + getName() + ", getReputation()=" + getReputation() + ", getRecievers()="
				+ getRecievers() + ", getTruthfullnessCoef()=" + getTruthfullnessCoef() + "]";
	}



}
