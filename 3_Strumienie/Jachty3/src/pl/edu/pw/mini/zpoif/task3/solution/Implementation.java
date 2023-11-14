package pl.edu.pw.mini.zpoif.task3.solution;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import pl.edu.pw.mini.zpoif.task3.generator.GeneratorStatkow;
import pl.edu.pw.mini.zpoif.task3.model.StatekNawodny;
import pl.edu.pw.mini.zpoif.task3.model.jacht.Jacht;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtKabinowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtMotorowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtOdkrytopokladowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtZaglowy;

public class Implementation implements Strumienie{
	
	List<StatekNawodny> statki = GeneratorStatkow.generujStatkiNawodne();
	
	@Override
	public StatekNawodny metoda1() {
		// TODO Auto-generated method stub
		return statki.stream()
				.min(Comparator.comparing(StatekNawodny::getMasa))
				.get();
	}

	@Override
	public JachtKabinowy metoda2() {
		// TODO Auto-generated method stub
		return statki.stream()
				.filter(n -> n instanceof JachtKabinowy)
				.map(JachtKabinowy.class::cast)
				.filter(n -> n.getNazwaProducenta().startsWith("J"))
				.max(Comparator.comparing(JachtKabinowy::getMasa))
				.get();
	}

	@Override
	public JachtZaglowy metoda3() {
		// TODO Auto-generated method stub
		return statki.stream()
				.filter(n -> n instanceof JachtZaglowy)
				.map(JachtZaglowy.class::cast)
				.min(Comparator.comparing(JachtZaglowy::getPowierzchniaZagla))
				.get();
	}

	@Override
	public JachtMotorowy metoda4() {
		// TODO Auto-generated method stub
		return statki.stream()
				.filter(n -> n instanceof JachtMotorowy)
				.map(JachtMotorowy.class::cast)
				.filter(n -> n.getMocSilnika() <= 250)
				.max(Comparator.comparing(JachtMotorowy::getMasa))
				.get();
	}

	@Override
	public List<JachtMotorowy> metoda5() {
		// TODO Auto-generated method stub
		return statki.stream()
				.limit(statki.size() - 2)
				.filter(n -> n instanceof JachtMotorowy)
				.map(JachtMotorowy.class::cast)
				.filter(n -> n.getMasa() >= 1400 && n.getDlugosc() >= 600)
				.limit(10)
				.collect(Collectors.toList());
	}

	@Override
	public List<JachtKabinowy> metoda6() {
		// TODO Auto-generated method stub
		return statki.stream()
				.filter(n -> n instanceof JachtZaglowy)
				.skip(4)
				.filter(n -> n instanceof JachtKabinowy)
				.map(JachtKabinowy.class::cast)
				.sorted(Comparator.comparing(JachtKabinowy::getPowierzchniaZagla).reversed())
				.limit(15)
				.collect(Collectors.toList());
	}

	@Override
	public List<JachtMotorowy> metoda7() {
		// TODO Auto-generated method stub
		return statki.stream()
				.skip(3)
				.filter(n -> n instanceof JachtMotorowy)
				.map(JachtMotorowy.class::cast)
				.sorted(Comparator.comparing(JachtMotorowy::getDlugosc))
				.limit(6)
				.sorted(Comparator.comparing(JachtMotorowy::getMocSilnika).reversed())
				.limit(3)
				.collect(Collectors.toList());
	}

	@Override
	public void metoda8() {
		// TODO Auto-generated method stub
		statki.stream()
		.filter(n -> n instanceof JachtMotorowy)
		.map(JachtMotorowy.class::cast)
		.filter(n -> n.getMocSilnika() > 500)
		.skip(1)
		.limit(3)
		.forEach(n -> {
			System.out.println( "Model "+ n.getTyp() +" jestdobry do Miami Vice!");
		});
	}

	@Override
	public String metoda9() {
		// TODO Auto-generated method stub
		return statki.stream()
				.skip(6)
				.filter(n -> n instanceof JachtKabinowy || n instanceof JachtOdkrytopokladowy)
				.filter(n -> n.getMasa() >= 500)
//				.map(n -> n.getDlugosc())
				.distinct()
				.limit(10)
				.collect(Collectors.summarizingInt(StatekNawodny::getDlugosc))
				.getSum() + "";
	}

	@Override
	public List<Jacht> metoda11() {
		// TODO Auto-generated method stub
		List<JachtOdkrytopokladowy> odkrytopokladowe = 
				statki.stream()
				.filter(n -> n instanceof JachtOdkrytopokladowy)
				.map(JachtOdkrytopokladowy.class::cast)
				.filter(n -> n.getTyp().length() <= 5)
				.sorted(Comparator.comparing(JachtOdkrytopokladowy::getDlugosc))
				.limit(2)
				.collect(Collectors.toList());
		List<JachtMotorowy> motorowe = 
				statki.stream()
				.filter(n -> n instanceof JachtMotorowy)
				.map(JachtMotorowy.class::cast)
				.filter(n -> n.getMocSilnika() > 300)
				.sorted(Comparator.comparing(JachtMotorowy::getDlugosc).reversed())
				.limit(4)
				.collect(Collectors.toList());
		List<Jacht> result = new LinkedList<>();
		result.addAll(motorowe);
		result.addAll(odkrytopokladowe);
		return result;
	}

}
