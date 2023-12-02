package pl.edu.pw.mini.zpoif.task5.solution;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.edu.pw.mini.zpoif.task5.machine.MafiaMachine;
import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.general.IllegalSeller;
import pl.edu.pw.mini.zpoif.task5.people.special.Accountant;
import pl.edu.pw.mini.zpoif.task5.people.special.ButtonMan;
import pl.edu.pw.mini.zpoif.task5.people.special.Controller;
import pl.edu.pw.mini.zpoif.task5.people.special.GodFather;
import pl.edu.pw.mini.zpoif.task5.people.special.Recruiter;
import pl.edu.pw.mini.zpoif.task5.people.special.Spy;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.DoIt;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.EncryptIt;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.ImportantWorkers;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.InitMe;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.PrimaryMafiaWorker;
import pl.edu.pw.mini.zpoif.task5.solution.annotation.SpyDetected;

public class Implementation extends MafiaMachine{
	List<Class<?>> classes = List.of(Accountant.class, ButtonMan.class, Controller.class, GodFather.class,
			Recruiter.class, Spy.class);
	@Override
	protected Set<MafiaWorker> createImportantMafiaWorkers() throws InstantiationException, IllegalAccessException{
		// TODO Auto-generated method stub
		
		Set<MafiaWorker> important = new HashSet<>();
		
		for (Class<?> clazz : classes) {
			if(clazz.isAnnotationPresent(ImportantWorkers.class) ) {
				ImportantWorkers annotation = clazz.getAnnotation(ImportantWorkers.class);
				for(int i = 0; i < annotation.quantity(); i++) {
					important.add((MafiaWorker)clazz.newInstance());
				}
			}
		}
		
		return important;
	}

	@Override
	protected MafiaWorker createPrimaryMafiaWorker() throws Exception {
		int counter = 0;
		Class szukanaKlasa = null;
		for(Class clazz : classes) {	
			if(clazz.isAnnotationPresent(PrimaryMafiaWorker.class)) {
				counter ++;
				if (counter > 1 ) {
					throw new Exception();
				}
				Class szukanaklasa = clazz;
			}
		}
		if (counter == 1){
			MafiaWorker mafiaWorker = (MafiaWorker) szukanaKlasa.newInstance();
			return mafiaWorker;
		}else {
			return null;
		}
		
	}

	@Override
	protected MafiaWorker createPrioritizedPrimaryMafiaWorker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void fillFields(Set<MafiaWorker> workers) throws Exception{
		// TODO Auto-generated method stub
		for(MafiaWorker worker : workers) {
			if(worker instanceof Accountant || worker instanceof IllegalSeller) {
				Field[] fields = worker.getClass().getDeclaredFields();
				for(Field field : fields) {
					if(field.isAnnotationPresent(EncryptIt.class) && String.class.equals(field.getType())) {
						field.setAccessible(true);
						field.set(worker, "java base64 example");
					}
				}
			}
		}
	}

	@Override
	protected ButtonMan getKiller(String name, String surname) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	protected void init(MafiaWorker mafiaWorker) throws Exception {
		// TODO Auto-generated method stub
		Field[] fields = mafiaWorker.getClass().getDeclaredFields();
		for(Field field : fields) {
			if(field.isAnnotationPresent(InitMe.class)) {
				field.set(mafiaWorker, field.getType().newInstance());
			}
		}
		
	}

	@Override
	protected void goButtonMan(Set<MafiaWorker> buttonMan) throws Exception{
		// TODO Auto-generated method stub
		for(MafiaWorker button : buttonMan) {
			Method[] methods = button.getClass().getDeclaredMethods();
			for(Method method : methods) {
				if(method.isAnnotationPresent(DoIt.class)) {
					DoIt annotation = method.getAnnotation(DoIt.class);
					method.setAccessible(true);
					for(int i = 0; i < annotation.times(); i++) {
						method.invoke(button);
					}
				}
			}
		}
	}

	@Override
	protected void spyNames(Set<MafiaWorker> workers) { // Wypisuje imiona i nazwiska wszyskich szpiegów
		// TODO Auto-generated method stub
		for(MafiaWorker worker : workers) {
			if(worker.getClass().isAnnotationPresent(SpyDetected.class)) {
				System.out.println("Imie: " + worker.getName() + ", Nazwisko: " + worker.getSurname());
			}
		}
	}


}
