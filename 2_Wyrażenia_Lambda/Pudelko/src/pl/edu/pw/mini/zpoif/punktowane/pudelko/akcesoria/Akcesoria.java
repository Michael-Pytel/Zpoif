package pl.edu.pw.mini.zpoif.punktowane.pudelko.akcesoria;

import pl.edu.pw.mini.zpoif.punktowane.pudelko.InitHelper;

public abstract class Akcesoria {
	private String producent;
	protected InitHelper initHelper = new InitHelper();

	public Akcesoria() {
		super();
		this.producent = initHelper.provideRandomProducerNameGenerator().get();
	}

	public String getProducent() {
		return producent;
	}

	public void setProducent(String producent) {
		this.producent = producent;
	}

}
