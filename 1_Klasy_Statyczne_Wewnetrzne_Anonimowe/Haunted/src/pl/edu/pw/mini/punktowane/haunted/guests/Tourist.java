package pl.edu.pw.mini.punktowane.haunted.guests;

public class Tourist extends Guest {

	@Override
	public void scareMe(int power) {
		// TODO Auto-generated method stub
		if (immunity < power && state != State.PANIC) {
			this.state = State.values()[State.valueOf(state + "").ordinal() + 1];
		} else if (immunity > power && state != State.NORMAL) {
			this.state = State.values()[State.valueOf(state + "").ordinal() - 1];
		}

	}

	@Override
	public String toString() {
		return "Tourist [state=" + state + "]";
	}

}
