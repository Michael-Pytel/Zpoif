package pl.edu.pw.mini.zpoif.punktowane.pudelko;

public class MyFunnyTools {

	// Wewnętrzny interfejs funkcyjny
	interface MyConcatenation {
		String myConcatenation(String str1, String str2);
	}

	// Metoda, która zwraca implementację interfejsu funkcyjnego z wykorzystaniem
	// referencji do metody
	public MyConcatenation createMyConcatenation() {
		return String::concat; // Mechanizm referencji do metody concat klasy String
	}

	public static void main(String[] args) {
		MyFunnyTools tools = new MyFunnyTools();
		MyConcatenation concatenation = tools.createMyConcatenation();

		String result = concatenation.myConcatenation("Hello", " World");
		System.out.println(result); // Wydrukuje "Hello World"
	}
}
