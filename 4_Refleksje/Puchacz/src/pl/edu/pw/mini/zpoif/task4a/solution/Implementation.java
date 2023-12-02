package pl.edu.pw.mini.zpoif.task4a.solution;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

import pl.edu.pw.mini.zpoif.task4a.Generator;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.Puchacz;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.Szybowiec;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.Kabina;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.inne.Instruktor;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.mechanizm.hamulec.HamulecAerodynamiczny;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.mechanizm.hamulec.HamulecKola;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.mechanizm.hamulec.HamulecKolaZWada;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.przyrzady.Wariometr;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.mechanizm.MechanizmSterowanyCiegnem;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.mechanizm.MechanizmWyczepiajacy;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.pdt.PokladowyDziennikTechniczny;
import pl.edu.pw.mini.zpoif.task4a.szybowiec.pdt.WpisSkrocony;

public class Implementation {
	Szybowiec puchacz = Generator.utworzPuchacza();
	
	protected Wariometr task1() throws Exception {
		// TODO Auto-generated method stub
		Class<?> wariometrClass = Class.forName("pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.przyrzady.Wariometr");
		Constructor<?> cons = wariometrClass.getConstructor();
		return (Wariometr) cons.newInstance();
	}
	
	public void task2() throws Exception {
        Method aero = HamulecAerodynamiczny.class.getDeclaredMethod("hamuj", int.class);
        aero.setAccessible(true);
        aero.invoke(puchacz, 50);
        
        Method kola = HamulecKola.class.getDeclaredMethod("hamuj", int.class);
        kola.setAccessible(true);
        kola.invoke(puchacz, 25);
        
    }
	public void task3() throws Exception{
		Class<?> clazzSzybowiec = puchacz.getClass();
		Field kabinaField = clazzSzybowiec.getDeclaredField("kabinaDruga");
		kabinaField.setAccessible(true);
		
		Class<?> kabinaClazz = kabinaField.getType().getSuperclass();
		Field tablicaField = kabinaClazz.getDeclaredField("tablicaPrzyrzadow");
		tablicaField.setAccessible(true);
		
		Object tablica = tablicaField.get(kabinaField.get(puchacz));
		
		Class<?> tablicaClass = tablicaField.getType();
		Class<?> wariometrZKompensatoremClazz = Class
				.forName("pl.edu.pw.mini.zpoif.task4a.szybowiec.kabina.przyrzady.WariometrZKompensatorem");
		Object wariometrZKompensatorem = wariometrZKompensatoremClazz.newInstance();
		
		Field wariometrField = tablicaClass.getDeclaredField("wariometr");
		wariometrField.setAccessible(true);
		wariometrField.set(tablica, wariometrZKompensatorem);
		
//		System.out.println(wariometrField.get(tablica).toString());
	}
	
	public static void task4() throws Exception {
		
		
        Field kabina = Kabina.class.getDeclaredField("kabinaDruga");

        Field[] fields = kabina.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (!field.getType().isAssignableFrom(String.class)) {
                continue; //Omija pola które nie są typu String 
            }

            if (field.getName().contains("uchwyt") && field.getModifiers() > java.lang.reflect.Modifier.PRIVATE) {
                continue; // Pmija pola prywatne , te które mają uchwyt w nazwie
            }

            field.setAccessible(true);
            String fieldValue = (String) field.get(kabina);
            System.out.println("Field: " + field.getName() + ", Color: " + fieldValue);
        }
    }
	public static void task5(MechanizmWyczepiajacy mechanism) throws NoSuchFieldException, IllegalAccessException {
        // Getting the field values using reflection
        Field triggerPositionField = MechanizmWyczepiajacy.class.getDeclaredField("wyzwalajacePolozenieUchwytuDoWyczepienia");
        Field maxTriggerPositionField = MechanizmWyczepiajacy.class.getDeclaredField("MAKSYMALNE_WYZWALAJACE_POLOZENIE_UCHWYTU_DO_WYCZEPIENIA");

        triggerPositionField.setAccessible(true);
        maxTriggerPositionField.setAccessible(true);

        // Getting the values of the fields
        int currentTriggerPosition = (int) triggerPositionField.get(mechanism);
        int maxTriggerPosition = (int) maxTriggerPositionField.get(mechanism);

        // Calculate the new value within the range of 10 to 20 less than the maximum trigger position
        int newValue = maxTriggerPosition - (10 + (int) (Math.random() * 11));

        // Ensure the new value is within valid range
        if (newValue < 0) {
            newValue = 0;
        }

        // Set the new value to the field
        triggerPositionField.set(mechanism, newValue);
    }
	
	public static boolean taks6() {
        return HamulecKolaZWada.class.isAssignableFrom(MechanizmSterowanyCiegnem.class);
    }
	
	public static void task7(Class<?> clazz) {
        Class<?> currentClass = clazz;

        while (currentClass != null) {
            Constructor<?>[] constructors = currentClass.getDeclaredConstructors();

            for (Constructor<?> constructor : constructors) {
                if (constructor.getParameterCount() > 1) {
                    System.out.println("Constructor with more than one parameter in class: " + currentClass.getName());
                }
            }

            currentClass = currentClass.getSuperclass();
        }
    }
	public static void task8() throws Exception {
        Instruktor instruktor = new Instruktor();
        Method[] methods = instruktor.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.getReturnType() != void.class && method.getParameterCount() == 1 &&
                method.getParameterTypes()[0] == boolean.class &&
                method.getDeclaringClass() == Instruktor.class) {

                // Generate random Boolean value
                boolean randomBoolean = new Random().nextBoolean();

                Object result = method.invoke(instruktor, randomBoolean);
                System.out.println("Method: " + method.getName() + ", Result: " + result);
            }
        }
    }
	
	public void task9() throws Exception {
         


        Field logbookField = Puchacz.class.getDeclaredField("pokladowyDziennikTechniczny");
        logbookField.setAccessible(true);

        PokladowyDziennikTechniczny logbook = (PokladowyDziennikTechniczny) logbookField.get(puchacz);


        List<WpisSkrocony> entries = logbook.getClass().getDeclaredField("wpisy");
        if (!entries.isEmpty()) {
            int randomIndex = new Random().nextInt(entries.size());
            entries.remove(randomIndex);

            // Create and add a new entry with correlated times
            WpisSkrocony newEntry = createCorrelatedEntry();
            entries.add(randomIndex, newEntry);

            System.out.println("Replaced logbook entry successfully.");
        } else {
            System.out.println("Logbook is empty. Cannot replace entry.");
        }
    }

    private static WpisSkrocony createCorrelatedEntry() {

        Random random = new Random();
        String pilotFirstName = "John";
        String pilotLastName = "Doe";
        int flightDuration = random.nextInt(360) + 60; // Duration between 1 and 6 hours in minutes
        return new WpisSkrocony(pilotFirstName, pilotLastName, flightDuration);
    }
}
	
	
	
	

