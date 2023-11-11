package pl.edu.pw.mini.punktowane.haunted.places;

import java.util.Random;

import pl.edu.pw.mini.punktowane.haunted.creature.Creature;
import pl.edu.pw.mini.punktowane.haunted.guests.Guest;

public class ApartmentUnpayed extends Place {
	protected Random rand = new Random();
	protected int inDebtBailiff = rand.nextInt(1, 10001);

	public ApartmentUnpayed() {

	}


	class Bailiff extends Creature {
		private int bailiffPower = inDebtBailiff / 500;

		@Override
		public void scareSomeone(Guest guest) {
			guest.scareMe(bailiffPower);
		}
	}

	@Override
	public void haunt(Guest guest) {
		scareBath(guest);
		scareLaundry(guest);
	}


	protected void scareBath(Guest guest) {
		// TODO Auto-generated method stub
		new Bailiff().scareSomeone(guest);
		new Bailiff().scareSomeone(guest);
	}


	protected void scareLaundry(Guest guest) {
		// TODO Auto-generated method stub
		new Bailiff().scareSomeone(guest);
	}

}
