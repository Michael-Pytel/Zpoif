package pl.edu.pw.mini.zpoif.graded.fourth;

import pl.edu.pw.mini.zpoif.graded.fourth.generator.GeneratorSamochodow;
import pl.edu.pw.mini.zpoif.graded.fourth.generator.Implementation;

public class Demonstrator {
	

	public static void main(String[] args) {
		Implementation demo = new Implementation(GeneratorSamochodow.generateAll());
		System.out.println(demo.getNajdluzszySamochod());
		System.out.println(demo.getSamochodONajmniejszejSzerokosci());
		System.out.println(demo.getNajlzejszySamochodWloski());
		System.out.println(demo.getCoNajwyzej3ZSamochodowMieszczacychSieWGarazu());
		System.out.println(demo.getSamochodyPosortowaneMalejacoWzgledemMasyPomniejszonejOSumeWymiarow());
		System.out.println(demo.getSamochodyNieLzejszeNiz1000KgINieSzerszeNiz170());
		System.out.println(demo.getPierwszePiecZPosortowanychMalejacoSNWzglWysok());
		System.out.println(demo.getSumaSzerokosciSamochodowJaponskichNieCiezszychNiz1000kgBezDwochPierwszych());
		System.out.println(demo.getCoNajwyzej4ZPosortowanychMalejacoWzglMasyPoczawszyOd10tego());
		System.out.println(demo.mapujModelNaSamochodTylkoWloskie());
		System.out.println(demo.getJaponskieSamochodyZamienioneNaWartosciIchMasy());
	}
}
