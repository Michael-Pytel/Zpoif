package pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices;

public class HandheldCBRadio extends RadioChanneled {

	private Boolean waterproof;

	public HandheldCBRadio(String manufacturer, int channel, double freq, Modulation modulation, Boolean waterproof) {
		super(manufacturer, channel, freq, modulation);
		// TODO Auto-generated constructor stub
		this.waterproof = waterproof;
	}

}
