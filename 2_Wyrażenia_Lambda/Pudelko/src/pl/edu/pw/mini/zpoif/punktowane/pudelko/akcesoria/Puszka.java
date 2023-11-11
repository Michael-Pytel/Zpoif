package pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria;

public class Puszka extends Kaloryczne {

	public Puszka() {
		this.kalorycznosc = initHelper.provideRandomCaloriesValue().generateRandomCalories(100, 150);
	}

}
