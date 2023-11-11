package pl.edu.pw.mini.zpoif.punktowane.pudelko;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria.Akcesoria;
import pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria.Gryzak;
import pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria.GryzakPiszczacy;
import pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria.Kaloryczne;
import pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria.Karma;
import pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria.Puszka;

public class MyDogBox {
	List<Akcesoria> listaAkcesoriow = new ArrayList<>();



	public MyDogBox() {
		for (int i = 0; i < 50; i++) {
			if (i < 20) {
				listaAkcesoriow.add(new Gryzak());
				listaAkcesoriow.add(new GryzakPiszczacy());
				listaAkcesoriow.add(new Karma());
				listaAkcesoriow.add(new Puszka());
			} else if (i < 40) {
				listaAkcesoriow.add(new Karma());
				listaAkcesoriow.add(new Puszka());
			} else {
				listaAkcesoriow.add(new Karma());
			}
		}

	}

	public void detectNonAttestationChew() {
		Consumer<Akcesoria> nonAttestationConsumer = akcesoria -> {
			if (akcesoria instanceof Gryzak && !((Gryzak) akcesoria).getAtest()) {
				System.out.println("Brak atestu!!!");
			}
		};

		listaAkcesoriow.forEach(nonAttestationConsumer);
	}

	public void detectCaloricFood() {
		AtomicInteger caloricFoodCount = new AtomicInteger(0);
		Consumer<Akcesoria> caloricConsumer = akcesoria -> {
			if (akcesoria instanceof Kaloryczne && ((Kaloryczne) akcesoria).getKalorycznosc() > 350
					&& caloricFoodCount.get() < 31) {
				System.out.println("Uwaga na kalorie");
				caloricFoodCount.incrementAndGet();
			}
		};

		listaAkcesoriow.forEach(caloricConsumer);
	}

	// Szybsza wersja
	public void detectCaloricFood2() {
		AtomicInteger caloricFoodCount = new AtomicInteger(0);

		listaAkcesoriow.forEach(akcesoria -> {
			if (akcesoria instanceof Kaloryczne && ((Kaloryczne) akcesoria).getKalorycznosc() > 350
					&& caloricFoodCount.get() < 31) {
				System.out.println("Uwaga na kalorie");
				caloricFoodCount.incrementAndGet();
			}
		});
	}

	public void getSummarizedDryFoodCalories() {
		AtomicInteger totalDryFoodCalories = new AtomicInteger(0);
		Consumer<Akcesoria> dryFoodConsumer = foodPackage -> {
			if (foodPackage instanceof Karma) {
				totalDryFoodCalories.addAndGet(((Kaloryczne) foodPackage).getKalorycznosc());
            }
        };
		listaAkcesoriow.forEach(dryFoodConsumer);
		System.out.println("Sumaryczna liczba kalorii dla suchej karmy: " + totalDryFoodCalories);
	}




	public static void main(String[] args) {
		MyDogBox myDogBox = new MyDogBox();

	}
}
