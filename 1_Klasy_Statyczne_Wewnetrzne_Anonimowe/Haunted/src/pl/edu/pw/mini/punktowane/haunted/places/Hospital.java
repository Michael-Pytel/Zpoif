package pl.edu.pw.mini.punktowane.haunted.places;

import pl.edu.pw.mini.punktowane.haunted.creature.Creature;
import pl.edu.pw.mini.punktowane.haunted.guests.Guest;
import pl.edu.pw.mini.punktowane.haunted.guests.State;

public class Hospital extends Place {

	@Override
	public void haunt(Guest guest) {
		// TODO Auto-generated method stub
		new Creature() {
			@Override
			public void scareSomeone(Guest guest) {
				if (guest.getState() == State.NORMAL) {
					guest.scareMe(15);
				}
			}
		};
	}

}
