package pl.edu.pw.mini.zpoif.task5.people.special;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.ImportantWorkers;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.PrimaryMafiaWorker;

@PrimaryMafiaWorker
@ImportantWorkers(quantity = 3)
public class Accountant extends MafiaWorker {
	
	protected String secondName;
	protected String school;
	
	public Accountant() {
		super();
	}

	public Accountant(String name, String surname) {
		super(name, surname);
	}

	public Accountant(String name) {
		super(name);
	}

}
