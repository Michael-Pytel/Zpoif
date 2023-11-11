package pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria;

import java.util.Random;

public class Gryzak extends Akcesoria {

	private Boolean atest;

	public Gryzak() {

		this.atest = initHelper.provideRandomAttestationGenerator(new Random().nextBoolean()).get();
	}

	public Boolean getAtest() {
		return atest;
	}

}
