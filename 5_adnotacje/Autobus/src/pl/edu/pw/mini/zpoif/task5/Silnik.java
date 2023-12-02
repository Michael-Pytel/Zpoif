package pl.edu.pw.mini.zpoif.task5;

import pl.edu.pw.mini.zpoif.task5.solution.annotations.MyConstructor;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.RandomIntInitiator;

public class Silnik {
	
	@MyConstructor
	public Silnik(@RandomIntInitiator(from = 50, to = 100) int moc, @RandomIntInitiator(from = 50, to = 100) int paliwo) {
		System.out.println("Moc: " + moc + ", Paliwo: " + paliwo);
	}
	
	@MyConstructor
	public Silnik(@RandomIntInitiator(from = 50, to = 100) int moc, int paliwo, boolean dziala) {
		System.out.println("Moc: " + moc + ", Paliwo: " + paliwo + ", Dziala: " + dziala);
	}
}
