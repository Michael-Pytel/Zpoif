package pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices;

public class RadioDevices {
	private String manufacturer;
	protected double freq;
	protected Modulation modulation;

	public enum Modulation {
		AM, FM
	}

	public RadioDevices(String manufacturer, double freq, Modulation modulation) {
		super();
		this.manufacturer = manufacturer;
		this.freq = freq;
		this.modulation = modulation;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setFreq(double freq) {
		this.freq = freq;
	}

	public void setModulation(Modulation modulation) {
		this.modulation = modulation;
	}

}
