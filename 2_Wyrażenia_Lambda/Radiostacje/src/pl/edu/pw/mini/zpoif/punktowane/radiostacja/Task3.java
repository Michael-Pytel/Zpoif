package pl.edu.pw.mini.zpoif.punktowane.radiostacja;

import java.util.Random;
import java.util.function.Consumer;

import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.RadioDevices.Modulation;
import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.ShortwaveRadiostation;
import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.StationaryCBRadio;

public class Task3 {
	Random rand = new Random();
	Consumer<String> startsWithA = s -> s.startsWith("A");
	Consumer<Integer> sinValue = s -> System.out.println(Math.sin(s));
	Consumer<ShortwaveRadiostation> changeShortwave = s -> {
		s.setFreq(rand.nextDouble() * 100);
		s.setModulation(Modulation.FM);
	};
	Consumer<StationaryCBRadio> changeStationary = s -> {
		int channel = rand.nextInt(40) + 1;
		s.setChannel(channel);
		s.setFreq(26.950 + channel * 0.01);
	};
}
