package pl.edu.pw.mini.zpoif.lab1.staticnested;

import java.util.ArrayList;

public class StaticClassTutorial {
	
	private static String staticValue = "First value...";
	private String nonStaticValue = "Second value";
	
	// Statyczna klasa wewnętrzna publczna
	public static class StaticNestedClass {
		
		public void changesValues() {
			staticValue = "Value changed"; // Metody klasy statycznej mają dostęp do pól statycznych
			
		}
	}
	private static class PrivateStaticNestedClass extends ArrayList<String> implements Comparable<String>{
		
		private static String staticString = "My static string...";
		
		@Override
		public int compareTo(String o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	// Statyczna klasa wewnetrzna publiczna
	// Klasy wewnetrzne mogą dziedziczyć po innych klasach wewnętrznych
	public static class ExtendedPrivateStaticNestedClass extends PrivateStaticNestedClass {
		
		public static void sayHello() {
			System.out.println("Public static method is saying hello!");
		}
		
		private static void sayHelloPrivate() {
			System.out.println("Private static method is saying hello!");
		}
		
		public void sayHelloNonStatic() {
			System.out.println("Public Non Static method is saying hello!");
		}
		
		private void sayHelloNonStaticPrivate() {
			System.out.println("Private Non static method is saying hello!");
		}
	}
	
	public static class CheckVisibility {
		// ExtendedPrivateStaticNestedClass.sayHello();
	}

	public void doWork() {
		StaticClassTutorial.StaticNestedClass staticNestedClass = new StaticClassTutorial.StaticNestedClass();
		StaticClassTutorial.PrivateStaticNestedClass privateStaticNestedClass = new StaticClassTutorial.PrivateStaticNestedClass();

		ExtendedPrivateStaticNestedClass.sayHello();

		// Metoda sayHelloPirvate jest prywatna, a mimo jest widoczna... dla klasy
		// StaticClassTutorial, w której została ona zadeklarowana
		ExtendedPrivateStaticNestedClass.sayHelloPrivate();
	}

	public class Triangle {

		private int base;
		private int height;

		public Triangle(int base, int height) {
			super();
			this.base = base;
			this.height = height;
		}

		public int getBase() {
			return base;
		}

		public int getHeight() {
			return height;
		}
	}
	
	public double calculateSurfaceArea(Triangle triangle) {
		return 0.5 * triangle.getBase() * triangle.getHeight();
	}
}
