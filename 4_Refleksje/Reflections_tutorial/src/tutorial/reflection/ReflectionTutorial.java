package tutorial.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTutorial {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Cat myCat = new Cat("Stella", 6);
		
		Field[] catFields = myCat.getClass().getDeclaredFields();
		
		for(Field field : catFields) {
//			System.out.println(field.getName());
			if(field.getName().equals("name")) {
				field.setAccessible(true); // makes it accessible to change the private field
				field.set(myCat, "Jimmy McGill");
			}
		}
		
		Method[] catMethods = myCat.getClass().getDeclaredMethods();
		
		for(Method method : catMethods) {
			if(method.getName().equals("heyThisIsPrivate")) {
				method.setAccessible(true);
				method.invoke(myCat);
			}
			if(method.getName().equals("thisIsAPublicStaticMethod")) {
//				method.setAccessible(true);
				method.invoke(null);
			}
			if(method.getName().equals("thisIsAPrivateStaticMethod")) {
				method.setAccessible(true);
				method.invoke(null);
			}
//			System.out.println(method.getName());
		}
//		System.out.println(myCat.getName());
	}

}
