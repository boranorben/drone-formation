package algorithm;

public class FirstMoveEvent extends Event {

	public FirstMoveEvent(double eventTime, Drone drone) {
		this.eventTime = eventTime;
		this.drone = drone;
		this.state = State.FIRST_MOVE;
	}

}
