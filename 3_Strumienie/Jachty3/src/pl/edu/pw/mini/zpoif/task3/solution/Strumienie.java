package pl.edu.pw.mini.zpoif.task3.solution;

import java.util.List;

import pl.edu.pw.mini.zpoif.task3.model.StatekNawodny;
import pl.edu.pw.mini.zpoif.task3.model.jacht.Jacht;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtKabinowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtMotorowy;
import pl.edu.pw.mini.zpoif.task3.model.jacht.JachtZaglowy;

public interface Strumienie {
	StatekNawodny metoda1();
	JachtKabinowy metoda2();
	JachtZaglowy metoda3();
	JachtMotorowy metoda4();
	List<JachtMotorowy> metoda5();
	List<JachtKabinowy> metoda6();
	List<JachtMotorowy> metoda7();
	void metoda8();
	String metoda9();
	List<Jacht> metoda11();
}
