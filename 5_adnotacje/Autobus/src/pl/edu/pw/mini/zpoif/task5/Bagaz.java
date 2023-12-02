package pl.edu.pw.mini.zpoif.task5;

import pl.edu.pw.mini.zpoif.task5.solution.annotations.InitiateObject;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.MyConstructor;

@InitiateObject(ilosc=15)
public class Bagaz {
	
	@MyConstructor
	public Bagaz() {
		System.out.println("this is bagaz");
	}
}
