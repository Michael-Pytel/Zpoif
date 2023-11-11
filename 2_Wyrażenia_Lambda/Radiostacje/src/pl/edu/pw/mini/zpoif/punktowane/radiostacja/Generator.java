package pl.edu.pw.mini.zpoif.punktowane.radiostacja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.CarCBRadio;
import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.HandheldCBRadio;
import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.RadioDevices;
import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.RadioDevices.Modulation;
import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.ShortwaveRadiostation;
import pl.edu.pw.mini.zpoif.punktowane.radiostacja.radiodevices.StationaryCBRadio;

public class Generator {

	@FunctionalInterface
	interface HandCBRadioGenerator {
		HandheldCBRadio generate(int channel);
	}

	@FunctionalInterface
	interface CarCBRadioGenerator {
		CarCBRadio generate(int channel);
	}

	@FunctionalInterface
	interface StationaryCBRadioGenerator {
		StationaryCBRadio generate(int channel, Modulation modulation);
	}

	@FunctionalInterface
	interface RadioGenerator {
		ShortwaveRadiostation generate();
	}

	public static List<RadioDevices> generateAll() {

		List<RadioDevices> radioList = new ArrayList<>();

		List<String> namesCarCB = new ArrayList<>(
				Arrays.asList("Cobra", "Zodiac", "President", "Uniden", "Midland", "Stryker"));
		List<String> namesHandCB = new ArrayList<>(Arrays.asList("ALAN", "Motorola"));
		List<String> namesRest = new ArrayList<>(Arrays.asList("STABO", "TEAMBSG", "RadMor", "Albrecht", "PNI_ESCORT",
				"CRTMIKE", "Galaxy", "PMR", "Midland"));

		Random random = new Random();

		HandCBRadioGenerator handCBRadioGenerator = (channel) -> {

			HandheldCBRadio radio = new HandheldCBRadio(namesHandCB.get(random.nextInt(namesHandCB.size())), channel,
					26.950 + channel * 0.01, Modulation.values()[random.nextInt(Modulation.values().length)],
					random.nextBoolean());

			return radio;
		};

		CarCBRadioGenerator carCBRadioGenerator = (channel) -> {

			CarCBRadio radio = new CarCBRadio(namesCarCB.get(random.nextInt(namesCarCB.size())), channel,
					26.950 + channel * 0.01, Modulation.values()[random.nextInt(Modulation.values().length)],
					random.nextBoolean());

			return radio;
		};

		StationaryCBRadioGenerator stationaryCBRadioGenerator = (channel, modulation) -> {

			StationaryCBRadio radio = new StationaryCBRadio(namesRest.get(random.nextInt(namesRest.size())), channel,
					26.950 + channel * 0.01, modulation);
			return radio;
		};

		RadioGenerator radioGenerator = () -> {

			ShortwaveRadiostation radio = new ShortwaveRadiostation(namesRest.get(random.nextInt(namesRest.size())),
					random.nextInt(100) + 1,
					Modulation.values()[random.nextInt(Modulation.values().length)]);

			return radio;
		};

		for (int i = 0; i < random.nextInt(5) + 1; i++) {
			radioList.add(handCBRadioGenerator.generate(random.nextInt(40) + 1));
		}

		for (int i = 0; i < random.nextInt(5) + 1; i++) {
			radioList.add(carCBRadioGenerator.generate(random.nextInt(40) + 1));
		}

		for (int i = 0; i < random.nextInt(5) + 1; i++) {
			radioList.add(stationaryCBRadioGenerator.generate(random.nextInt(40) + 1,
					Modulation.values()[random.nextInt(Modulation.values().length)]));
		}

		for (int i = 0; i < random.nextInt(5) + 1; i++) {
			radioList.add(radioGenerator.generate());
		}

		return radioList;
	}
}
