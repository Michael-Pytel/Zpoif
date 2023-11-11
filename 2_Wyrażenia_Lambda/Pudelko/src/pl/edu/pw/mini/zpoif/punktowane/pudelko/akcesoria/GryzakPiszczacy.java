package pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria;

public class GryzakPiszczacy extends Gryzak {
	private int freq;

	public GryzakPiszczacy() {

		this.freq = initHelper.provideRandomFrequencyGenerator().get();
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

}
