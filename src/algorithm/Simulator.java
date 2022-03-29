package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import application.MainSceneController;

public class Simulator {
	private MainSceneController uiController;
	private Base baseController;
	private PriorityQueue<Event> eventList;

	private double interAddTime;
//	private double sumWaitingTime;

	public Simulator(MainSceneController uiController) {
		this.uiController = uiController;
		this.baseController = new Base();
		this.eventList = new PriorityQueue<Event>(new Event());

		this.interAddTime = 0;
	}

	public void addDrone(int droneId, double degree, int velocity, int duration, double interAddTime) {
		List<Direction> dValue = Arrays.asList(Direction.values());
		Direction direction = null;
		for (Direction d : dValue) {
			if (d.degree == degree) {
				direction = d;
				break;
			}
		}
		Drone drone = new Drone(droneId, direction, velocity, duration, interAddTime);
		this.baseController.addDrone(drone);
		this.eventList.offer(new AddEvent(interAddTime, drone));
	}

	public ArrayList<Drone> getDrones() {
		return this.baseController.getDrones();
	}

	public void startEvents() {
		double serviceTime;

		while (!this.eventList.isEmpty()) {
			Event event = this.eventList.poll();
			State eventState = event.getState();

			switch (eventState) {
			case ADD:
				this.interAddTime = event.getDrone().getAddTime();
				eventList.add(new FirstMoveEvent(this.interAddTime, event.getDrone()));
				continue;
			case FIRST_MOVE:
				serviceTime = this.interAddTime;
				serviceTime += event.getDrone().getDuration();
				// do something about moving
				break;
			case PACKET_SEND:
				break;
			case ADJUST_MOVE:
				break;
			case DONE:
				break;
			default:
				break;
			}
		}
	}

}
