package pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices;

public class RadioChanneled extends RadioDevices {

	private int channel;

	public RadioChanneled(String manufacturer, int channel, double freq, Modulation modulation) {
		super(manufacturer, freq, modulation);
		// TODO Auto-generated constructor stub
		this.channel = channel;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

}
