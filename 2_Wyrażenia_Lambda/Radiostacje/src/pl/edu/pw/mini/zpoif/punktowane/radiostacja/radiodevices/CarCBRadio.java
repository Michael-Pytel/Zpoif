package pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices;

public class CarCBRadio extends RadioChanneled {

	private Boolean homologation;

	public CarCBRadio(String manufacturer, int channel, double freq, Modulation modulation, Boolean homologation) {
		super(manufacturer, channel, freq, modulation);
		// TODO Auto-generated constructor stub
		this.homologation = homologation;
	}

}
