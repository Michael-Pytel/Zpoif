package pl.edu.pw.mini.zpoif.lab1.annonymous;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AnonymousClassOwner {
	private String globalDateFormat = "HH:mm:ss.SSS";

	public void processTask(TaskRunnable taskRunnable) {
		taskRunnable.doWork();
	}

	public void processAnotherTask(TaskRunner taskRunner) {
		// do something
		taskRunner.doWork();
		// do something else
	}

	// Możemy wyprodukować implementacje interfejsu za pomocą klasy anonimowej

	public TaskRunnable createTask() {
		return new TaskRunnable(){

			@Override
			public String getFormattedDateOLastTaskRun() {
				SimpleDateFormat format = new SimpleDateFormat(globalDateFormat);
				globalDateFormat = "";
				return format.format(new Date());
			}

			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				System.out.println("Working");
			}
			
		};
	}
}
