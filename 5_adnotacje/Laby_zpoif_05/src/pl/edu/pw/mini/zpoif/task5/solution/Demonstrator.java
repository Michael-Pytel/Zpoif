package pl.edu.pw.mini.zpoif.task5.solution;

import java.util.Set;

import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.special.ButtonMan;
import pl.edu.pw.mini.zpoif.task5.people.special.Spy;

public class Demonstrator {
	public static void main(String[] args) throws Exception {
		Implementation demo = new Implementation();
		
		Set<MafiaWorker> mafiaWorkers = demo.createImportantMafiaWorkers();
//		demo.fillFields(mafiaWorkers);
//		demo.init(new GodFather());
		
		mafiaWorkers.add(new ButtonMan());
//		demo.goButtonMan(mafiaWorkers);
		mafiaWorkers.add(new Spy("Michael", "Jackson"));
		mafiaWorkers.add(new Spy("Michael", "sdf"));
		demo.spyNames(mafiaWorkers);
		
	}
}
