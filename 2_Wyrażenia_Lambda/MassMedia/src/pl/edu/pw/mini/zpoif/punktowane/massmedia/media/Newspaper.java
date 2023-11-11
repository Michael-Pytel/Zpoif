package pl.edu.pw.mini.zpoif.punktowane.massmedia.media;

public class Newspaper extends MassMedia {
	private int volume;
	private int pages;

	public Newspaper(String name, int reputation, int volume, int pages) {
		super(name, reputation);
		this.volume = volume;
		this.pages = pages;
	}
	@Override
	public String toString() {
		return "Newspaper [getName()=" + getName() + ", getReputation()=" + getReputation() + ", volume=" + volume
				+ ", pages=" + pages + "]";
	}


}
