package pl.edu.pw.mini.zpoif.punktowane.radiostacja;

import java.util.Comparator;
import java.util.List;

import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.HandheldCBRadio;
import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.RadioDevices;

public class Sorter {
	private static Comparator<RadioDevices> byName = (a, b) -> Integer.compare(a.getManufacturer().length(),
			b.getManufacturer().length());

	private static Comparator<RadioDevices> byChannel = (a,
			b) -> (a instanceof HandheldCBRadio && b instanceof HandheldCBRadio)
					? Integer.compare(((HandheldCBRadio) a).getChannel(), ((HandheldCBRadio) b).getChannel())
					: 0;

	public static List<RadioDevices> sortByTelevision(List<RadioDevices> radioDevicesList) {
		radioDevicesList.sort(byName);
		return radioDevicesList;
	}

	public static List<RadioDevices> sortByRecievers(List<RadioDevices> radioDevicesList) {
		radioDevicesList.sort(byChannel);
		return radioDevicesList;
	}
}
