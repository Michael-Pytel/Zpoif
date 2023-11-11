package pl.edu.pw.mini.punktowane.haunted.places;

import pl.edu.pw.mini.punktowane.haunted.creature.Creature;
import pl.edu.pw.mini.punktowane.haunted.guests.Guest;

public class Castle extends Place {
	private static int WhiteLadyPower = 20;
	
	public class WhiteLady extends Creature {

		@Override
		public void scareSomeone(Guest guest) {
			// TODO Auto-generated method stub
			guest.scareMe(WhiteLadyPower);
		}
		
	}

	@Override
	public void haunt(Guest guest) {
		// TODO Auto-generated method stub
		new WhiteLady().scareSomeone(guest);
		
		class OwnerGhost extends Creature {

			@Override
			public void scareSomeone(Guest guest) {
				// TODO Auto-generated method stub
				guest.scareMe(0);
			}

		}
		new OwnerGhost().scareSomeone(guest);
		new OwnerGhost().scareSomeone(guest);
	}
}
