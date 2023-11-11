package pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria;

public class Karma extends Kaloryczne {

	public Karma() {
		this.kalorycznosc = initHelper.provideRandomCaloriesValue().generateRandomCalories(300, 400);
	}

}
