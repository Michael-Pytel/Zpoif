package pl.edu.pw.mini.zpoif.punktowane.pudelko;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria.GryzakPiszczacy;
import pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria.Puszka;

public class MyDogBoxSub extends MyDogBox {
	public void upgradeProducerName(String newName) {
		listaAkcesoriow.forEach(foodPackage -> {
			if (foodPackage.getProducent().length() <= 5) {
				foodPackage.setProducent(newName);
			}
		});
	}

	public void upgradeFrequency4All(int newFrequency) {
        int newFrequencyValue = new Random().nextInt(8,13) *2;

        listaAkcesoriow.forEach(foodPackage -> {
            if (foodPackage instanceof GryzakPiszczacy) {
                ((GryzakPiszczacy) foodPackage).setFreq(newFrequencyValue);
            }
        });
    }

	public void getAverageWetFoodCalories() {
		
		
		AtomicInteger totalWetFoodCalories = new AtomicInteger(0);
		AtomicInteger wetFoodCount = new AtomicInteger(0);

		listaAkcesoriow.forEach(foodPackage -> {
			if (foodPackage instanceof Puszka) {
				totalWetFoodCalories.addAndGet(((Puszka) foodPackage).getKalorycznosc());
				wetFoodCount.incrementAndGet();
			}
		});

		if (wetFoodCount.get() > 0) {
			double averageWetFoodCalories = (double) totalWetFoodCalories.get() / wetFoodCount.get();
			System.out.println("Średnia wartość kaloryczna karmy w puszkach: " + averageWetFoodCalories);
		} else {
			System.out.println("Brak puszek w liście.");
		}
	}
}

