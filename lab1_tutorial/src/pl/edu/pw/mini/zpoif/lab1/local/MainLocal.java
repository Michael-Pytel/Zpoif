package pl.edu.pw.mini.zpoif.lab1.local;

public class MainLocal {
	public static void main(String[] args) {
		LocalClassOwner localClassOwner = new LocalClassOwner();
		System.out.println(localClassOwner.getFemaleName());
		localClassOwner.printSorted();
	}
}
