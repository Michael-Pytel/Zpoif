package pl.edu.pw.mini.zpoif.lab1.annonymous;

public abstract class TaskRunner {
	private long lastCall;

	abstract String getFormattedDateOfLastTaskRun();

	void doWork() {
		lastCall = System.currentTimeMillis();
		System.out.println("Hello, hello I am doing the hard work...");
	}
}
