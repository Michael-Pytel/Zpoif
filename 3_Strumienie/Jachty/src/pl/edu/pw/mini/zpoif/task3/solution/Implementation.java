package pl.edu.pw.mini.zpoif.task3.solution;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import pl.edu.pw.mini.zpoif.task3.generator.GeneratorStatkow;
import pl.edu.pw.mini.zpoif.task3.model.StatekNawodny;
import pl.edu.pw.mini.zpoif.task3.model.jacht.Jacht;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtKabinowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtMotorowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtOdkrytopokladowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtZaglowy;

public class Implementation implements Statki {
	List<StatekNawodny> statkiNawodne = GeneratorStatkow.generujStatkiNawodne();

	@Override
	public StatekNawodny getNajciezszyStatek() {
		// TODO Auto-generated method stub
//		return statkiNawodne.stream().sorted((s1, s2) -> Integer.compare(s2.getMasa(), s1.getMasa()))
//				.collect(Collectors.toList()).get(0);
		return statkiNawodne.stream().max(Comparator.comparing(StatekNawodny::getMasa)).get();
	}

	@Override
	public StatekNawodny getStatekONajdluzszejNazwieProducentaNaR() {
		// TODO Auto-generated method stub
		return statkiNawodne.stream()
				.filter(n -> n.getNazwaProducenta().startsWith("R"))
				.max(Comparator.comparing( s -> s.getNazwaProducenta().length())).get();
	}

	@Override
	public JachtMotorowy getJachtMotorowyONajwiekszejMocySilnika() {
		return statkiNawodne.stream()
				.filter(n -> n instanceof JachtMotorowy)
				.map(JachtMotorowy.class::cast)
				.max(Comparator.comparing(JachtMotorowy::getMocSilnika))
				.get();
	}

	@Override
	public JachtKabinowy getLekkiJachtKabinowyONajmniejszymOzaglowaniu() {
		// TODO Auto-generated method stub
		return statkiNawodne.stream()
				.filter(n -> n instanceof JachtKabinowy)
				.map(JachtKabinowy.class::cast)
				.filter(n -> n.getMasa() < 1000)
				.min(Comparator.comparing(JachtKabinowy::getPowierzchniaZagla))
				.get();
	}

	@Override
	public Set<StatekNawodny> getCoNajwyzej11DlugichICiezkichJachtow() {
		// TODO Auto-generated method stub
		return statkiNawodne.stream()
				.filter(n -> n instanceof Jacht)
				.filter(s -> s.getMasa() > 1400)
				.filter(s -> s.getDlugosc() > 700)
				.limit(11)
				.collect(Collectors.toSet());
	}

	@Override
	public List<StatekNawodny> getStatkiPosortowaneWzgledemDlugosciBez2() {
		// TODO Auto-generated method stub
		return statkiNawodne.stream()
				.skip(2)
				.sorted(Comparator.comparing(StatekNawodny::getDlugosc).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<JachtZaglowy> getPierwsze8ZPosortowanychWzgledemOzaglowaniaBezTrzechPierwszych() {
		// TODO Auto-generated method stub
		return statkiNawodne.stream()
				.filter(n -> n instanceof JachtZaglowy)
				.map(JachtZaglowy.class::cast)
				.sorted(Comparator.comparing(JachtZaglowy::getPowierzchniaZagla).reversed())
				.skip(3)
				.limit(8)
				.collect(Collectors.toList());
	}

	@Override
	public void oznaczJachtyDobreNaPlycizny() {
		// TODO Auto-generated method stub
		statkiNawodne.stream()
				.filter(n -> n instanceof JachtKabinowy)
				.map(JachtKabinowy.class::cast)
				.filter(s -> s.getZanurzenie() <= 30)
				.filter(s -> s.getMasa() > 1300)
				.forEach(s -> s.setKomentarz("Jachtem "+ s.getTyp() +" wplyniesz na kazda plycizne!"));
	}

	@Override
	public String get12UnikalnychNazwTypow() {
		// TODO Auto-generated method stub
		return statkiNawodne.stream()
				.filter(s -> s instanceof Jacht)
				.map(Jacht.class::cast)
				.filter(s -> s.getMasa() > 2000)
				.map(Jacht::getTyp)
				.distinct()
				.skip(3)
				.limit(12)
				.collect(Collectors.joining("-"));
	}

	@Override
	public Map<String, JachtMotorowy> getMapaJachtowMotorowych() {
		// TODO Auto-generated method stub
		return statkiNawodne.stream()
				.filter(n -> n instanceof JachtMotorowy)
				.map(JachtMotorowy.class::cast)
				.sorted(Comparator.comparing(s -> s.getNazwaProducenta().length()))
				.distinct()
				.collect(Collectors.toMap(JachtMotorowy::getTyp, s->s));
	}

	@Override
	public List<Jacht> getJachtyOdkrytopokladoweIMotoroweJednePoDrugich() {
		// TODO Auto-generated method stub
		
		List<JachtOdkrytopokladowy> odkrytopokladowe = 
				statkiNawodne.stream()
				.filter(n -> n instanceof JachtOdkrytopokladowy)
				.map(JachtOdkrytopokladowy.class::cast)
				.limit(10)
				.collect(Collectors.toList());
		List<JachtMotorowy> motorowe = 
				statkiNawodne.stream()
				.filter(n -> n instanceof JachtMotorowy)
				.map(JachtMotorowy.class::cast)
				.filter(n -> n.getNazwaProducenta().equalsIgnoreCase("regal"))
				.skip(4).limit(4).
				collect(Collectors.toList());
		List<Jacht> result = new LinkedList<>();
		result.addAll(odkrytopokladowe);
		result.addAll(motorowe);
		return result;
	}

}
