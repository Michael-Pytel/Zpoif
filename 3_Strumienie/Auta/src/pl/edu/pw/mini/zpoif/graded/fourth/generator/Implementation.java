package pl.edu.pw.mini.zpoif.graded.fourth.generator;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import pl.edu.pw.mini.zpoif.graded.fourth.auta.Samochod;
import pl.edu.pw.mini.zpoif.graded.fourth.auta.SamochodJaponski;
import pl.edu.pw.mini.zpoif.graded.fourth.auta.SamochodNiemiecki;
import pl.edu.pw.mini.zpoif.graded.fourth.auta.SamochodWloski;

public class Implementation implements Strumienie{
	List<Samochod> samochody;

	public Implementation(List<Samochod> samochody) {
		super();
		this.samochody = samochody;
	}

	@Override
	public Samochod getNajdluzszySamochod() {
		// TODO Auto-generated method stub
		return samochody.stream()
				.max(Comparator.comparing(Samochod::getDlogosc)).get();
	}

	@Override
	public Samochod getSamochodONajmniejszejSzerokosci() {
		// TODO Auto-generated method stub
		return samochody.stream()
				.min(Comparator.comparing(Samochod::getSzerokosc)).get();
	}

	@Override
	public Samochod getNajlzejszySamochodWloski() {
		// TODO Auto-generated method stub
		return samochody.stream()
				.filter( n -> n instanceof SamochodWloski)
				.min(Comparator.comparing(Samochod::getMasaWlasna)).get();
	}

	@Override
	public List<Samochod> getCoNajwyzej3ZSamochodowMieszczacychSieWGarazu() {
		// TODO Auto-generated method stub
		return samochody.stream()
				.filter(n -> n.getDlogosc() <= 500)
				.filter(n -> n.getSzerokosc() <= 160)
				.filter(n -> n.getWysokosc() <= 150)
				.limit(3)
				.collect(Collectors.toList());
	}

	@Override
	public Set<Samochod> getSamochodyPosortowaneMalejacoWzgledemMasyPomniejszonejOSumeWymiarow() {
		// TODO Auto-generated method stub
//		return samochody.stream()
//				.sorted((s1,s2) -> Integer.compare(s1.getMasaWlasna() - (s1.getDlogosc() + s1.getSzerokosc() + s1.getWysokosc()),
//						s2.getMasaWlasna() - (s2.getDlogosc() + s2.getSzerokosc() + s2.getWysokosc())))
//				.collect(Collectors.toSet());
		Function<Samochod, Integer> v = s -> s.getMasaWlasna() -(s.getWysokosc() + s.getSzerokosc() + s.getDlogosc());
		return samochody.stream()
				.sorted((a,b) -> v.apply(b).compareTo(v.apply(a)))
				.collect(Collectors.toCollection(() -> new TreeSet<>((a,b) -> v.apply(b).compareTo(v.apply(a))))); 
	}

	@Override
	public List<Samochod> getSamochodyNieLzejszeNiz1000KgINieSzerszeNiz170() {
		// TODO Auto-generated method stub
		return samochody.stream()
				.filter(n -> n.getMasaWlasna() > 1000)
				.filter(n -> n.getSzerokosc() < 170)
				.collect(Collectors.toList());
		
	}

	@Override
	public List<Samochod> getPierwszePiecZPosortowanychMalejacoSNWzglWysok() {
		// TODO Auto-generated method stub
		return samochody.stream()
				.filter(n -> n instanceof SamochodNiemiecki)
				.sorted(Comparator.comparing(Samochod::getWysokosc).reversed())
				.limit(5)
				.collect(Collectors.toList());
	}

	@Override
	public long getSumaSzerokosciSamochodowJaponskichNieCiezszychNiz1000kgBezDwochPierwszych() {
		// TODO Auto-generated method stub
		return samochody.stream()
				.filter(n -> n.getMasaWlasna() <= 1000)
				.filter(n -> n instanceof SamochodJaponski)
				.skip(2)
				.collect(Collectors.summarizingLong(Samochod::getSzerokosc))
				.getSum();
	}

	@Override
	public List<Samochod> getCoNajwyzej4ZPosortowanychMalejacoWzglMasyPoczawszyOd10tego() {
		// TODO Auto-generated method stub
		return samochody.stream()
				.skip(5)
				.sorted(Comparator.comparing(Samochod::getMasaWlasna).reversed())
				.limit(4)
				.collect(Collectors.toList());
	}

	@Override
	public Map<String, Samochod> mapujModelNaSamochodTylkoWloskie() {
		// TODO Auto-generated method stub
		return samochody.stream()
				.filter(n -> n instanceof SamochodWloski)
				.collect(Collectors.toMap(Samochod::getMarka, s -> s, (existing, replacement) -> existing));
	}

	@Override
	public Collection<Integer> getJaponskieSamochodyZamienioneNaWartosciIchMasy() {
		// TODO Auto-generated method stub
		return samochody.stream()
				.filter(n -> n instanceof SamochodJaponski)
				.map(Samochod::getMasaWlasna)
				.collect(Collectors.toList());
	}
	
	
}
