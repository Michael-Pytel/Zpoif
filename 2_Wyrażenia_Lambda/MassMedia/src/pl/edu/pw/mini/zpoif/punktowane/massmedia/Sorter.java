package pl.edu.pw.mini.zpoif.punktowane.massmedia;

import java.util.Comparator;
import java.util.List;

import pl.edu.pw.mini.zpoif.punktowane.massmedia.media.MassMedia;
import pl.edu.pw.mini.zpoif.punktowane.massmedia.media.Television;
import pl.edu.pw.mini.zpoif.punktowane.massmedia.media.Transmitted;

public class Sorter {

	private static Comparator<MassMedia> byTelevision = (a, b) -> Boolean.compare(a instanceof Television,
			b instanceof Television);

	private static Comparator<MassMedia> byRecievers = (a, b) -> (a instanceof Transmitted && b instanceof Transmitted)
			? Integer.compare(((Transmitted) a).getRecievers(), ((Transmitted) b).getRecievers())
			: 0;

	public static List<MassMedia> sortByTelevision(List<MassMedia> mediaList) {
		mediaList.sort(byTelevision);
		return mediaList;
	}

	public static List<MassMedia> sortByRecievers(List<MassMedia> mediaList) {
		mediaList.sort(byRecievers);
		return mediaList;
	}

	public static void main(String[] args) {
		System.out.println(sortByTelevision(new Generator().generateAll()));
		System.out.println(sortByRecievers(new Generator().generateAll()));
	}
}
