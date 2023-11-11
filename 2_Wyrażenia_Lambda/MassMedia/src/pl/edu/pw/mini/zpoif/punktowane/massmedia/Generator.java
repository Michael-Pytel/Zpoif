package pl.edu.pw.mini.zpoif.punktowane.massmedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import pl.edu.pw.mini.zpoif.punktowane.massmedia.media.MassMedia;
import pl.edu.pw.mini.zpoif.punktowane.massmedia.media.Newspaper;
import pl.edu.pw.mini.zpoif.punktowane.massmedia.media.Radio;
import pl.edu.pw.mini.zpoif.punktowane.massmedia.media.Television;

public class Generator {

	Random random = new Random();

	@FunctionalInterface
	interface RadioGenerator {
		Radio generate();
	}

	@FunctionalInterface
	interface TVGenerator {
		Television generate();
	}

	@FunctionalInterface
	interface NewspaperGenerator {
		Newspaper generate();
	}

	public List<MassMedia> generateAll() {
		
		List<String> tvNames = new ArrayList<>(
				Arrays.asList("CNNW", "FoxNews", "NBCC", "NHHK", "Jetix2", "Khabara TV", "UTVa"));

		List<String> radioNames = new ArrayList<>(Arrays.asList("Rouge FMa", "China National Radio New", "City FM 899",
				"Radio Hauraki2", "JFNK", "Today FM news"));

		List<String> newspaperNames = new ArrayList<>(
				Arrays.asList("El Universala", "La Prensaco", "Tal Cualana", "Barbadian2", "Pepper PunchX"));

		List<MassMedia> listOfMedia = new ArrayList<>();

		RadioGenerator radioGenerator = () -> new Radio(radioNames.get(random.nextInt(radioNames.size())),
				random.nextInt(100) + 1,
				random.nextInt(1000000000), random.nextInt(100) + 1);

		TVGenerator tvGenerator = () -> new Television(tvNames.get(random.nextInt(tvNames.size())),
				random.nextInt(200) + 1,
				random.nextInt(500000001), random.nextInt(100) + 1, random.nextBoolean());

		NewspaperGenerator newspaperGenerator = () -> new Newspaper(
				newspaperNames.get(random.nextInt(newspaperNames.size())),
				random.nextInt(220) + 1, random.nextInt(100001), random.nextInt(100));

		for (int i = 0; i < 5; i++) {
			listOfMedia.add(tvGenerator.generate());
			listOfMedia.add(radioGenerator.generate());
			listOfMedia.add(newspaperGenerator.generate());
		}

		return listOfMedia;
	}
}
