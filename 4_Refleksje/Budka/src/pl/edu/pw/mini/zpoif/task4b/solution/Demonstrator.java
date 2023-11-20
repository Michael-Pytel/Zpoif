package pl.edu.pw.mini.zpoif.task4b.solution;

import pl.edu.pw.mini.zpoif.task4b.building.WygodnaBudka;

public class Demonstrator {
	public static void main(String[] args) throws Exception{
		Implementation demo = new Implementation();
		WygodnaBudka wygodnaBudka = demo.task1();
		demo.task2(wygodnaBudka);
		demo.task3(wygodnaBudka);
		demo.task4(wygodnaBudka);
		demo.task5();
		System.out.println();
		System.out.println(demo.task6());
//		demo.task7(wygodnaBudka);
		demo.task8();
		
	}
}
