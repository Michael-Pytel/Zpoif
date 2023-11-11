package pl.edu.pw.mini.punktowane.haunted.places;

import pl.edu.pw.mini.punktowane.haunted.creature.Creature;
import pl.edu.pw.mini.punktowane.haunted.guests.Guest;

public class ApartmentUnpayedWater extends ApartmentUnpayed {

	int inDebtBailiff = rand.nextInt(1, 10001);
	
	@Override
	public void haunt(Guest guest) {
		if (rand.nextBoolean()) {
			scareBath(guest);
		} else {
			scareLaundry(guest);
		}
	}

	private class SwimmerGost extends Creature {
		@Override
		public void scareSomeone(Guest guest) {
			guest.scareMe(rand.nextInt(10, 31));
		}
	}
	@Override
	protected void scareBath(Guest guest) {
		// TODO Auto-generated method stub
		new Bailiff().scareSomeone(guest);
	}

	@Override
	protected void scareLaundry(Guest guest) {
		// TODO Auto-generated method stub
		new SwimmerGost().scareSomeone(guest);
	}

}
