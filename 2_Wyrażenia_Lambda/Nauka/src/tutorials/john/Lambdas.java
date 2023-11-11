package tutorials.john;

public class Lambdas {

	public static void main(String[] args) {
		Cat myCat = new Cat();
//		myCat.print();
		printThing(myCat);

		printThing(() -> System.out.println("Meow")); // implementation of the functional interface without creating a
														// separate class that implements the Printable interface

		Printable lambdaPrintable = () -> System.out.println("Meow");
		printThing(lambdaPrintable);

		Printable1 lambdaprintable1 = (s) -> System.out.println("Meow" + s);
		printThing(lambdaprintable1);

		Printable2 lambdaPrintable2 = (p, s) -> System.out.println(p + "Meow" + s);
		printThing(lambdaPrintable2);

		Printable3 lambdaPrintable3 = (s) -> {
			System.out.println("Meow" + s);
			return s;
		};
		printThing(lambdaPrintable3);

		Printable3 lambdaPrintable4 = (s) -> "Meow" + s;
		printThing(lambdaPrintable4);
	}

	static void printThing(Printable thing) {
		thing.print();
	}

	static void printThing(Printable1 thing) {
		thing.print("!");
	}

	static void printThing(Printable2 thing) {
		thing.print("Hau ", "!");
	}

	static void printThing(Printable3 thing) {
		thing.print("!");
	}
}
