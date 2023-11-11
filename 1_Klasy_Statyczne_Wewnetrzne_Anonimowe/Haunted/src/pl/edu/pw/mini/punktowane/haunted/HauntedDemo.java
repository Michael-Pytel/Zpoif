package pl.edu.pw.mini.punktowane.haunted;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pw.mini.punktowane.haunted.guests.Guest;
import pl.edu.pw.mini.punktowane.haunted.guests.Student;
import pl.edu.pw.mini.punktowane.haunted.guests.Tourist;
import pl.edu.pw.mini.punktowane.haunted.places.ApartmentUnpayed;
import pl.edu.pw.mini.punktowane.haunted.places.ApartmentUnpayedWater;
import pl.edu.pw.mini.punktowane.haunted.places.Castle;
import pl.edu.pw.mini.punktowane.haunted.places.Hospital;

public class HauntedDemo {
	public static void main(String[] args) {
		Castle castle = new Castle();
		Hospital hospital = new Hospital();
		ApartmentUnpayed apartmentUnpayed = new ApartmentUnpayed();
		ApartmentUnpayedWater apartmentUnpayedWater = new ApartmentUnpayedWater();

		List<Guest> guests = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			guests.add(new Student());
			guests.add(new Tourist());
		}

		for (int i = 0; i < 10; i++) {
			castle.haunt(guests.get(i));
			hospital.haunt(guests.get(i));
			apartmentUnpayed.haunt(guests.get(i));
			apartmentUnpayedWater.haunt(guests.get(i));
		}

	}
}
