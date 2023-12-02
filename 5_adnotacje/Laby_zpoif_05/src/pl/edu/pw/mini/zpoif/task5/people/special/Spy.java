package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.PrimaryMafiaWorker;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.SpyDetected;

@SpyDetected
@PrimaryMafiaWorker
public class Spy extends MafiaWorker {

	public Spy() {
		super();
	}

	public Spy(String name, String surname) {
		super(name, surname);
	}

	public Spy(String name) {
		super(name);
	}

}
