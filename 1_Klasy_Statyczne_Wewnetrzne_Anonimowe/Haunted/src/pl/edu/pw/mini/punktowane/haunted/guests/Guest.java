package pl.edu.pw.mini.punktowane.haunted.guests;

import java.util.Random;

public abstract class Guest {

	protected int immunity;
	protected State state;
	private Random rand = new Random();

	public Guest() {
		super();
		this.immunity = rand.nextInt(10, 21);
		this.state = State.NORMAL;
	}

	public State getState() {
		return state;
	}


	public abstract void scareMe(int power);
}
