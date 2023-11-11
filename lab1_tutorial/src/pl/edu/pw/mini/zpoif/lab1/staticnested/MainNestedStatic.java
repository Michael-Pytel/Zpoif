package pl.edu.pw.mini.zpoif.lab1.staticnested;

public class MainNestedStatic {
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		StaticClassTutorial.StaticNestedClass staticNestedClass = new StaticClassTutorial.StaticNestedClass();
	}
}
