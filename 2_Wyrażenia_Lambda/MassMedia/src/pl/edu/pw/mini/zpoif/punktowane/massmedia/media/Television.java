package pl.edu.pw.mini.zpoif.punktowane.massmedia.media;

public class Television extends Transmitted {

	private Boolean isInformative;

	public Television(String name, int reputation, int recievers, int truthfullnessCoef, Boolean isInformative) {
		super(name, reputation, recievers, truthfullnessCoef);
		this.isInformative = isInformative;
	}

	@Override
	public String toString() {
		return "Television [getName()=" + getName() + ", getReputation()=" + getReputation() + ", getRecievers()="
				+ getRecievers() + ", getTruthfullnessCoef()=" + getTruthfullnessCoef() + ", isInformative="
				+ isInformative + "]";
	}


}
