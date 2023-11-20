package pl.edu.pw.mini.zpoif.task4b.solution;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import pl.edu.pw.mini.zpoif.task4b.building.Budka;
import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;

public class Implementation extends Solution{

	@Override
	protected WygodnaBudka task1() throws Exception {
		// TODO Auto-generated method stub
		Class<?> budkaClass = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Constructor<?> cons = budkaClass.getConstructor();
		return (WygodnaBudka) cons.newInstance();
	}

	@Override
	protected void task2(WygodnaBudka wygodnaBudka) throws Exception {
		// TODO Auto-generated method stub
		Field field = WygodnaBudka.class.getDeclaredField("bazgrol");
		field.setAccessible(true);
		System.out.println(field.get(wygodnaBudka));
		
	}

	@Override
	protected void task3(WygodnaBudka wygodnaBudka) throws Exception {
		// TODO Auto-generated method stub
		Field field = WygodnaBudka.class.getDeclaredField("szyfrDoSejfu");
		field.setAccessible(true);
		Field uniCode = Budka.class.getDeclaredField("UNIWERSALNY_SZYFR_DO_SEJFU");
		uniCode.setAccessible(true);
		String code = (String) uniCode.get(wygodnaBudka);
		field.set(wygodnaBudka, code);
		
	}

	@Override
	protected void task4(WygodnaBudka wygodnaBudka) throws Exception {
		// TODO Auto-generated method stub
		Method[] methods = WygodnaBudka.class.getMethods();
		
		for(Method method : methods) {
			if(method.getReturnType().equals(Integer.TYPE)){
				System.out.println(method.getName());
				System.out.println(method.invoke(method));
				break;
			}
		}
		
	}

	@Override
	protected void task5() throws Exception {
		// TODO Auto-generated method stub
		Field field = WygodnaBudka.class.getDeclaredField("dobreWyrko");
		field.setAccessible(true);
		Class<?> valueClass = field.getType();
		while(!valueClass.getSimpleName().equals("Object")) {
			valueClass = valueClass.getSuperclass();
			System.out.print(valueClass.getSimpleName() + " ");
		}
	}

	@Override
	protected WygodnaBudka task6() throws Exception {
		// TODO Auto-generated method stub
		Class<?> budkaClass = Class.forName("pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka");
		Constructor<?> cons = budkaClass.getConstructor(String.class, String.class);
		return (WygodnaBudka) cons.newInstance("Super", "Dobre Graty");
	}

	@Override
	protected void task7(WygodnaBudka wygodnaBudka) throws Exception {
		// TODO Auto-generated method stub
		Class<?> safe = null;
		
		for(Class<?> declaredClass : WygodnaBudka.class.getDeclaredClasses()) {
			if(declaredClass.getSimpleName().equals("sejf")) {
				safe = declaredClass;
				break;
			}
		}
		Field passField = WygodnaBudka.class.getDeclaredField("szyfrDoSejfu");
		passField.setAccessible(true);
		String safePass = (String) passField.get(wygodnaBudka);
		Field safeField = WygodnaBudka.class.getDeclaredField("sejf");
		safeField.setAccessible(true);
		assert safe != null;
		Constructor<?> cons = safe.getConstructor(WygodnaBudka.class);
		cons.setAccessible(true);
		
		Method openSafe = safe.getDeclaredMethod("open");
		openSafe.invoke(safePass);
	}

	@Override
	protected void task8() throws Exception {
		// TODO Auto-generated method stub
		for(Class<?> declaredClass : WygodnaBudka.class.getSuperclass().getDeclaredClasses()) {
			declaredClass.getProtectionDomain();
		}
	}

	@Override
	protected int task9(WygodnaBudka wygodnaBudka) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
