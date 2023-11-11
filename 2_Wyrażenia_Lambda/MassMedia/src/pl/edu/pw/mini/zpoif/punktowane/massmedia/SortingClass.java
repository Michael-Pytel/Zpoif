package pl.edu.pw.mini.zpoif.punktowane.massmedia;

import java.util.Comparator;
import java.util.List;

import pl.edu.pw.mini.zpoif.punktowane.massmedia.media.MassMedia;
import pl.edu.pw.mini.zpoif.punktowane.massmedia.media.Television;

public class SortingClass {
	public static List<MassMedia> sortingMethod(List<MassMedia> sortedList) {

		Comparator<MassMedia> tvLast = (a, b) -> (a instanceof Television) ? 1 : -1;
		sortedList.sort(tvLast);

		return sortedList;
	}
	


	public static void main(String[] args) {
		Generator generator = new Generator();
		System.out.println(sortingMethod((generator.generateAll())));
	}
}
