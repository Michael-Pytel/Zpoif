package pl.edu.pw.mini.zpoif.punktowane.massmedia.media;

public abstract class MassMedia {

	private String name;
	private int reputation;


	public MassMedia(String name, int reputation) {
		super();
		this.name = name;
		this.reputation = reputation;
	}

	public String getName() {
		return name;
	}

	public int getReputation() {
		return reputation;
	}








}
