package pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.rozwiazanie;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.NapedzanyStatekPowietrzny;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.Samolot;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.Smiglowiec;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.Spadochron;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.StatekPowietrzny;
import pl.edu.pw.mini.zpoif.zadanieoceniane.strumienie.statkipowietrzne.Szybowiec;

public class Implementation implements Strumienie{
	List<StatekPowietrzny> statkiPowietrzne;
	List<NapedzanyStatekPowietrzny> napedzaneStatkiPowietrzne;
	
	
	public Implementation(List<StatekPowietrzny> statkiPowietrzne,
			List<NapedzanyStatekPowietrzny> napedzaneStatkiPowietrzne) {
		super();
		this.statkiPowietrzne = statkiPowietrzne;
		this.napedzaneStatkiPowietrzne = napedzaneStatkiPowietrzne;
	}

	@Override
	public StatekPowietrzny getNajlzejszyStatekPowietrzny() {
		// TODO Auto-generated method stub
		return statkiPowietrzne.stream()
				.min(Comparator.comparing(StatekPowietrzny::getMasa))
				.get();
	}

	@Override
	public StatekPowietrzny getNajciezszySmiglowiec() {
		// TODO Auto-generated method stub
		return statkiPowietrzne.stream()
				.filter(n -> n instanceof Smiglowiec)
				.skip(2)
				.max(Comparator.comparing(StatekPowietrzny::getMasa))
				.get();
	}

	@Override
	public Smiglowiec getSmiglowiecONajmniejszymWirniku() {
		// TODO Auto-generated method stub
		return statkiPowietrzne.stream()
				.filter(n -> n instanceof Smiglowiec)
				.map(Smiglowiec.class::cast)
				.skip(1)
				.filter(n -> n.getTyp().toLowerCase().startsWith("mi"))
				.min(Comparator.comparing(Smiglowiec::getSrednicaWirnika))
				.get();
	}

	@Override
	public Set<StatekPowietrzny> getSamolotyLatajaceWyzejNiz19000M() {
		// TODO Auto-generated method stub
		return statkiPowietrzne.stream()
				.filter(n -> n instanceof Samolot)
				.map(Samolot.class::cast)
				.skip(4)
				.filter(n -> n.getPulap() > 19000 && n.getPowierzchniaNosna() >= 25)
				.limit(7)
				.collect(Collectors.toSet());
	}

	@Override
	public List<NapedzanyStatekPowietrzny> getPosortowane() {
		// TODO Auto-generated method stub
		return napedzaneStatkiPowietrzne.stream()
				.filter(s -> s.getPredkoscWznoszenia() >= 100)
				.skip(4)
				.sorted(Comparator.comparing(NapedzanyStatekPowietrzny::getZasieg).reversed())
				.limit(3)
				.collect(Collectors.toList());
	}

	@Override
	public Szybowiec getSzybowiecONajwiekszejDoskonalosciINajnizszejMasie() {
		// TODO Auto-generated method stub
		
		return statkiPowietrzne.stream()
				.filter(n -> n instanceof Szybowiec)
				.map(Szybowiec.class::cast)
				.sorted(Comparator.comparing(Szybowiec::getDoskonalosc).reversed())
				.limit(3)
				.min(Comparator.comparing(Szybowiec::getMasa))
				.get();
	}

	@Override
	public Map<String, StatekPowietrzny> getSamolotyOPowierzchniNosniejWiekszejNiz20() {
		// TODO Auto-generated method stub
		return napedzaneStatkiPowietrzne.stream()
				.filter(n -> n instanceof Samolot)
				.map(Samolot.class::cast)
				.filter(n -> n.getPowierzchniaNosna() > 20)
				.collect(Collectors.toMap(Samolot::getTyp,
						s -> s, 
						(existing, replacement) -> {
	                        if (existing.getMasa() < replacement.getMasa()) {
	                            System.out.println("Replacing existing with replacement: " + existing + " with " + replacement);
	                            return existing;
	                        } else {
	                            System.out.println("Keeping existing, not replacing: " + existing + " with " + replacement);
	                            return replacement;
	                        }
	                    }));
	}

	@Override
	public int getSumeDoskonalosciSzybowcowOMasieWiekszejNiz350PoczOdDrugiego() {
		// TODO Auto-generated method stub
		return (int) statkiPowietrzne.stream()
				.skip(1)
				.filter(n -> n instanceof Szybowiec)
				.map(Szybowiec.class::cast)
				.filter(n -> n.getMasa() >= 350)
				.collect(Collectors.summarizingInt(Szybowiec::getDoskonalosc))
				.getSum();
	}

	@Override
	public List<StatekPowietrzny> getPierwszePiecSamolotowLubSpadochronowPosortowanychMalejacoPoMasiePoczOd2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Spadochron> getMapeSpadochronowODopMasieSkoczkaWiekszejNiz85IgnorujDuplikaty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void zmienNazwyTypowWZaleznosciOdPierwszychElementow() {
		if()
		
	}

}
