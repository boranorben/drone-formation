package algorithm;

import java.util.Comparator;

public class Event implements Comparator<Event> {
	protected double eventTime;
	protected State state;
	protected Drone drone;
	protected Base baseController;

	public double getEventTime() {
		return this.eventTime;
	}

	public State getState() {
		return this.state;
	}

	public Drone getDrone() {
		return this.drone;
	}

	public Base getBaseController() {
		return this.baseController;
	}

	@Override
	public int compare(Event o1, Event o2) {
		return (o1.getEventTime() < o2.getEventTime()) ? -1 : (o1.getEventTime() > o2.getEventTime()) ? 1 : 0;
	}
}
