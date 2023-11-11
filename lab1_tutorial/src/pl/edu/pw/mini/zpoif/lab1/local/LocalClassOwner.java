package pl.edu.pw.mini.zpoif.lab1.local;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class LocalClassOwner {
	private List<Person> persons;

	public LocalClassOwner() {
		persons = new ArrayList<>();
		persons.add(new Person(1, "John", "Bravo", 55, true));
		persons.add(new Person(2, "Amelia", "Smith", 23, false));
		persons.add(new Person(3, "Todd", "Rodd", 23, true));
		persons.add(new Person(4, "Kill", "Bill", 41, true));
		persons.add(new Person(5, "Alicia", "Cooper", 1, false));
		persons.add(new Person(6, "Monika", "Jankowska", 31, false));
		persons.add(new Person(7, "Kamil", "Milowicz", 31, true));
	}

	public String getFemaleName() {
		class FemaleInfo {
			private Person person;
			private long time;

			public FemaleInfo(Person person) {
				super();
				this.person = person;
				this.time = System.currentTimeMillis();
			}

			@Override
			public String toString() {
				return person.getName() + " " + time;
			}
		}
		List<FemaleInfo> females = new ArrayList<>();

		for (Person person : persons) {
			if (!person.isMale() && person.getAge() > 20) {
				System.out.println("Added: " + person.getAge());
				females.add(new FemaleInfo(person));

			}
		}

		return females.get(((new Random()).nextInt(females.size()))).toString();

	}

	public void printSorted() {
		class LocalComparator implements Comparator<Person> {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getAge().compareTo(o2.getAge());
			}
		}
		LocalComparator localComparator = new LocalComparator();
		List<Person> personsToSort = new ArrayList<>(persons);

		Collections.sort(personsToSort, localComparator);

		for (Person person : personsToSort) {
			System.out.println(person.toString());
		}
	}
}
