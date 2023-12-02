package pl.edu.pw.mini.zpoif.task5.machine;

import java.util.Set;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.special.ButtonMan;

public abstract class MafiaMachine {

	protected abstract Set<MafiaWorker> createImportantMafiaWorkers() throws Exception;
	protected abstract MafiaWorker createPrimaryMafiaWorker() throws Exception;
	protected abstract MafiaWorker createPrioritizedPrimaryMafiaWorker();
	protected abstract void fillFields(Set<MafiaWorker> workers) throws Exception;
	protected abstract ButtonMan getKiller(String name, String surname);
	protected abstract void init(MafiaWorker mafiaWorker) throws Exception;
	protected abstract void goButtonMan(Set<MafiaWorker> buttonMan) throws Exception;

	protected abstract void spyNames(Set<MafiaWorker> workers);

}
