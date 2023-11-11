package pl.edu.pw.mini.zpoif.lab1.annonymous;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainAnonymousClassesTest {
	public static void main(String[] args) {
		AnonymousClassOwner anonymousClassOwner = new AnonymousClassOwner();
		String localDateFormat = "dd-MM-YYY";

		anonymousClassOwner.processTask(new TaskRunnable() {

			private long taskRunTime;

			@Override
			public String getFormattedDateOLastTaskRun() {
				SimpleDateFormat format = new SimpleDateFormat(localDateFormat);

				return format.format(new Date(taskRunTime));
			}

			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				taskRunTime = System.currentTimeMillis();
				System.out.println("Hello hello, I am doing hard work!");

			}

		});

		// Możemy wyprodukować anonimowe rozszerzenie klasy abstrakcyjnej
		anonymousClassOwner.processAnotherTask(new TaskRunner() {

			@Override
			String getFormattedDateOfLastTaskRun() {
				// TODO Auto-generated method stub

				SimpleDateFormat format = new SimpleDateFormat(localDateFormat);
				return format.format(new Date());
			}

		});
	}
}
