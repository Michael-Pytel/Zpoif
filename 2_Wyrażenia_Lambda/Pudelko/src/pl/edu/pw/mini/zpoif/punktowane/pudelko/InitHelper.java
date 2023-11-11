package pl.edu.pw.mini.zpoif.punktowane.pudelko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class InitHelper {
	static Random random = new Random();

	public Supplier<String> provideRandomProducerNameGenerator() {
		ArrayList<String> names = new ArrayList<>(
				Arrays.asList("DINGO", "FAFIK", "My pet", "LAPA", "CERBER", "raBIES"));
		return () -> names.get(random.nextInt(names.size()));
	}

	public Supplier<Integer> provideRandomFrequencyGenerator() {
		return () -> random.nextInt(8, 13) * 2;
	}

	public Supplier<Boolean> provideRandomAttestationGenerator(boolean alwaysTrue) {
		return () -> alwaysTrue ? true : (random.nextDouble() <= 0.95 ? true : false);
	}


	@FunctionalInterface
	public interface RandomCaloriesGenerator {
		public int generateRandomCalories(int x, int y);
	}

	public RandomCaloriesGenerator provideRandomCaloriesValue() {
		return (x, y) -> {
			if (x > y) {
				return random.nextInt(y, x + 1);
			}
			return random.nextInt(x, y + 1);
		};
	}

}
