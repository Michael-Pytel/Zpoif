package pl.edu.pw.mini.zpoif.punktowane.massmedia;

import java.util.function.Consumer;

public class Task3 {
	public static void main(String[] args) {
		Consumer<String> startsWithA = s -> s.startsWith(s);
		Consumer<String> print = s -> System.out.println(s);
		Consumer<String> reverseString = s -> new StringBuilder(s).reverse().toString();

		class Sum {
			private int sum = 0;

			void inc(int s) {
				sum += s;
			}

			int get() {
				return sum;
			}
		}
		Sum sum = new Sum();

		Consumer<String> isDigit = s -> {
			try {
				Integer i = Integer.parseInt(s);
				sum.inc(i);
				System.out.println(i + " : " + (i % 2 == 0 ? "parzysta" : "nieparzysta"));
				System.out.println("Suma: " + sum.get());

			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
		};
	}
}
