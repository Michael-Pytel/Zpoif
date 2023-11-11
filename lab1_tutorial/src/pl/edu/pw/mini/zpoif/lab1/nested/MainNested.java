package pl.edu.pw.mini.zpoif.lab1.nested;

public class MainNested {
	public static void main(String[] args) {
		NestedClassTutorial nestedClassTutorial = new NestedClassTutorial("First");
		nestedClassTutorial.doWork();

		NestedClassTutorial.NestedClass nestedClassInstantiatedExternally = new NestedClassTutorial(
				"Tenth").new NestedClass();
	}
}
