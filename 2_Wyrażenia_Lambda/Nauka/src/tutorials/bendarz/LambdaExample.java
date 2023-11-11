package tutorials.bendarz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class LambdaExample {

	private int oneSide = 5;

	// Method showing some of the examples of lambda expressions and more..
	public void doExample() {

		// We will implement this interface
		SurfaceCalculator surfaceCalculator;

		/*
		 * Załóżmy, że mamy klasę JustCalculator, która posiada metodę pobierającą co
		 * implementuje interfejs SurfaceCalulator (implementacje kalkulatora liczącego
		 * pole powierzchni prostoąta) i uruchamia ją w ciele metody. Sama nie chce
		 * zajmować się obliczeniami. Załóżmy, że woli korzystać z implementacji, której
		 * metoda przyjmuje jako parametr.
		 */
		JustCalculator justCalculator = new JustCalculator();

		/*
		 * Instancja klasy JustCalculator zawiera tylko jedną metodę calculate, która
		 * przyjmuję obiekt do implementujący wspomniany powyżej interfejs i uruchamia
		 * obliczenie pola powierzchni. justCalculator.calculate(coś, co policzy nam
		 * pole powierzchni).
		 * 
		 */

		/*
		 * We can create somewhere in packages of our classes that implement
		 * SurfaceCalculator and use it. Methods of providing implementation in shape of
		 * a class: 1. make a separate file 2. give name 3. define the body 4. define
		 * head of implemented method 5. Implement the body of the method
		 * 
		 * If:
		 */

		surfaceCalculator = new SurfaceCalculatorImpl();
		System.out.println("Surface area of a rectangle by the standard implementing class: "
				+ surfaceCalculator.calculateSurfaceAreaOfARectangle(10, 12));

		justCalculator.calculate(surfaceCalculator);

		/*
		 * Nothing stands in the way to make it in a similar fashion but in this place,
		 * doing only these steps: 2. give name 3. define the body 4. define head of
		 * implemented method 5. Implement the body of the method
		 */
		class SurfaceCalculatorImplemented implements SurfaceCalculator {

			@Override
			public int calculateSurfaceAreaOfARectangle(int a, int b) {
				// TODO Auto-generated method stub
				return a * b;
			}
		}
		SurfaceCalculatorImplemented surfaceCalculatorImplemented = new SurfaceCalculatorImplemented();
		System.out.println("Surface area as per the local implementing class: "
				+ surfaceCalculatorImplemented.calculateSurfaceAreaOfARectangle(10, 12));

		// The implementation of the interface can be passed on to a method of a class
		// JustCalculator
		justCalculator.calculate(surfaceCalculatorImplemented);

		/*
		 * If the situation does not require of using any of the good that classes
		 * provide, and we care only about passing on (mostly one time only) some simple
		 * code, than we can use lambda expressions. It is much easier and it requires
		 * much less code than the other methods
		 * 
		 * There is only one action that has to be made for the same result as before
		 */
		surfaceCalculator = (a, b) -> a * b;
		System.out.println("Surface area of a square defined with lambda expression: "
				+ surfaceCalculator.calculateSurfaceAreaOfARectangle(2, 2));
		justCalculator.calculate(surfaceCalculator);

		// Lambda expressions can have more than one line
		surfaceCalculator = (a, b) -> {
			if (a > 100 && b > 100) {
				System.out.println("Thats a big recrangle...");
			} else if (a < 2 && b < 2) {
				System.out.println("And that is supposed to be a rectangle?");
			}
			Date date = new Date();
			System.out.println("Waring! In a while calculating of a rectangle will be taking place " + date);
			return a * b;
		};
		justCalculator.calculate(surfaceCalculator);

		/*
		 * If the implemented method has one parameter, we can use it without
		 * parenthesis Like in this situation:
		 */
		TextSurrounder textSurrounder = text -> System.out.println("[Left]" + text + "[Right]");
		textSurrounder.surroundText("Text to surround");

		/*
		 * The scope of lambda expressions is relative to the place, that it was
		 * implemented The next example does not use from the parameters a and b. To
		 * demonstrate this feature calling to a field of a class LambdaExample and a
		 * local field otherSide.
		 * 
		 */
		int otherSide = 11;
		surfaceCalculator = (a, b) -> this.oneSide * otherSide;
		justCalculator.calculate(surfaceCalculator);

		// Or we can do it even faster
		justCalculator.calculate((a, b) -> this.oneSide + otherSide);

		// This is how we can implement a thread
		Runnable run = () -> System.out.println("A tread written in a lambda...");
		(new Thread(run)).start();

		// Sorting by the length of a string
		Comparator<String> comparatorFromLambda = (a, b) -> a.length() > b.length() ? 1 : -1;

		// Let's see if it works
		List<String> list = new ArrayList<String>(Arrays.asList("Short", "Medium", "Long String", "Very Long String"));
		list.sort(comparatorFromLambda);
		System.out.println("Sorted list: " + list);

		/*
		 * It is good to remember that lambda expressions are used, when a problem can
		 * be resolved with a code inside a specified method, if there is no reference
		 * to additional methods and fields of a class that implements the interface
		 * 
		 */

		/*
		 * Task: write an implementation of an interface java.util.Comparator<String>,
		 * that compares Strings in alphabetical order and every third comparison prints
		 * to the console information "Every third comparison..."
		 */
		Comparator<String> comparator = new Comparator<String>() {
			private int count;

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (++count % 3 == 0) {
					System.out.println("Every third comparison...");
				}
				return o1.compareTo(o2);
			}

		};
		List<String> list2 = new ArrayList<String>(Arrays.asList("Raz", "Dwa", "Trzy", "Cztery", "A nawet pi��"));
		list2.sort(comparator);
		System.out.println("Posortowana lista: " + list2);
	}

}
