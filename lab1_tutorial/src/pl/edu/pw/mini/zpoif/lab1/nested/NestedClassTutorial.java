package pl.edu.pw.mini.zpoif.lab1.nested;

public class NestedClassTutorial {

	private String internalValue;
	private int secretNumber = 18;

	public NestedClassTutorial(String internalValue) {
		super();
		this.internalValue = internalValue;
	}

	public class NestedClass {

		public void doSomething() {
			System.out.println("Print secret number: " + secretNumber);
		}

		public String getInternalValue() {
			return internalValue;
		}
	}

	public void sayHello() {
		System.out.println("Hello it is main class (NestedClassTutorial).");
	}

	public class Refer2MyMethod {
		public void sayHello() {
			System.out.println("Hello it is a nested class (Refer2MyMethod)");
		}

		public void doSomething() {
			sayHello();
			this.sayHello();

			NestedClassTutorial.this.sayHello();
		}
	}

	public class ExtendingClass extends Thread implements Comparable<ExtendingClass> {

		@Override
		public int compareTo(ExtendingClass o) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

	public void doWork() {
		// Inside a class containing nested classes we do not need to
		// use this kind of : NestedClassTutorial.NestedClass.
		NestedClass myNestedClass = new NestedClass();

		// but we can still do it
		NestedClassTutorial.NestedClass nestedClassInitializedInAnotherWay = new NestedClassTutorial(
				"Second").new NestedClass();
		NestedClassTutorial.NestedClass nestedClassInitializedInAnotherWay2 = new NestedClassTutorial(
				"Third").new NestedClass();

		// or this way
		NestedClassTutorial.NestedClass nestedClassInitializedPayAnother = this.new NestedClass();

		System.out.println("\nmyNestedClass-internalValue: " + myNestedClass.getInternalValue()
				+ "\nnestedClassInitializedAnotherWay-internalvalue: "
				+ nestedClassInitializedInAnotherWay.getInternalValue()
				+ "\nnestedClassInitializedAnotherWay2-internalvalue: "
				+ nestedClassInitializedInAnotherWay2.getInternalValue()
				+ "\nnestedClassInitializedPayAnother-internalValue: " + nestedClassInitializedPayAnother);
	}
}
