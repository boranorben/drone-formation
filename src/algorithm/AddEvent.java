package algorithm;

public class AddEvent extends Event {

	public AddEvent(double eventTime, Drone drone) {
		this.eventTime = eventTime;
		this.drone = drone;
		this.state = State.ADD;
	}

}
