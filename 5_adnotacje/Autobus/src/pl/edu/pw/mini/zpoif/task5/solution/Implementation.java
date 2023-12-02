package pl.edu.pw.mini.zpoif.task5.solution;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import pl.edu.pw.mini.zpoif.task5.solution.annotations.AddMulti;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.InitiateObject;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.MethodInvoker;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.MyConstructor;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.RandomIntInitiator;

public class Implementation {
	private final List<Class<?>> classes  = Helper.classes;
	List<Object> obiekty = new ArrayList<>();
	
	void task3() {
		for (Class<?> clazz : classes) {
			if(clazz.isAnnotationPresent(InitiateObject.class) && !Modifier.isAbstract(clazz.getModifiers())) {
				InitiateObject annotation = clazz.getAnnotation(InitiateObject.class);
				for(int i = 0; i < annotation.ilosc(); i++) {
					obiekty.add(clazz);
				}
			}
		}
		
		Collections.shuffle(obiekty);
	}
	
	void task4() throws Exception{
		for(Object obj : obiekty) {
			for (Method method : obj.getClass().getDeclaredMethods()) {
				if(method.isAnnotationPresent(MethodInvoker.class)) {
					MethodInvoker annotation = method.getAnnotation(MethodInvoker.class);
					for(int i = 0; i < annotation.licznikWywolan().getValue() ; i++) {
						method.invoke(obj);
					}
				}
			}
		}
	}
	
//	void task5() {
//		
//		for (Class<?> clazz : classes) {
//			Constructor<?>[] constructors = clazz.getDeclaredConstructors();
//			for(Constructor<?> cons : constructors) {
//				Parameter[] parameters = cons.getParameters();
//				int counter = 0;
//				if(cons.isAnnotationPresent(MyConstructor.class)) {
//					for(Parameter param : parameters) {
//						if(param.isAnnotationPresent(RandomIntInitiator.class)) {
//							counter++;
//						}
//					}
//					if (counter == cons.getParameterCount()) {
//						for(Parameter param : parameters) {
//							RandomIntInitiator annotation = param.getAnnotation(RandomIntInitiator.class);
//							int from = annotation.from();
//			                int to = annotation.to();
//			                int randomValue = new Random().nextInt(to - from + 1) + from;
//						}
//					}
//				}
//			}
//		}
//	}
	
	void task5() throws Exception{
		for (Class<?> clazz : classes) {
			Constructor<?>[] constructors = clazz.getDeclaredConstructors();
			for(Constructor<?> cons : constructors) {
				if (cons.isAnnotationPresent(MyConstructor.class)) {
					Parameter[] parameters = cons.getParameters();
			        Object[] args = new Object[parameters.length];
			        boolean allParamsInitiated = true;

			        for (int i = 0; i < parameters.length; i++) {
			            Parameter parameter = parameters[i];
			            if (parameter.isAnnotationPresent(RandomIntInitiator.class)) {
			                RandomIntInitiator annotation = parameter.getAnnotation(RandomIntInitiator.class);
			                int from = annotation.from();
			                int to = annotation.to();
			                int randomValue = new Random().nextInt(to - from + 1) + from;
			                args[i] = randomValue;
			            } else {
			                allParamsInitiated = false;
			                break;
			            }
			        }
			        
			        if (allParamsInitiated) {
		               obiekty.add(cons.newInstance(args));
			        }
				}
            }
		}
	}
	
	void task6() {
		for(Object obj : obiekty) {
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields) {
				if(field.isAnnotationPresent(AddMulti.class)) {
					if(List.class.isAssignableFrom(field.getType()) || Set.class.isAssignableFrom(field.getType())) {
						AddMulti annotation = field.getAnnotation(AddMulti.class);
						Class<?>[] clazz = annotation.value();
						int count = new Random().nextInt(10) + 1;
						int counter = 0;
						for(Object innerObiect : obiekty) {
							if(obiekt.getClass() == annotation.value()[0].getClass() && counter <= count) {
								counter++;
								field.setAccessible(true);
								
							}
						}
					}
				}
			}
		}
	}
}
