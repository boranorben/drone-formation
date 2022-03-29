package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Base {
	private ArrayList<Drone> drones;
	private Queue<Drone> queue;
	private boolean isBusy;
	private double availableTime;

	public Base() {
		this.drones = new ArrayList<Drone>();
		this.queue = new LinkedList<Drone>();
		this.isBusy = false;
		this.availableTime = 0;
	}

	public void addDrone(Drone drone) {
		this.drones.add(drone);
	}

	public ArrayList<Drone> getDrones() {
		return this.drones;
	}

	public boolean isBusy() {
		return this.isBusy;
	}

	public void addQueue(Drone drone) {
		this.queue.add(drone);
	}

	public Drone popQueue() {
		return this.queue.poll();
	}

	public void setTime(double time) {
		this.availableTime = time;
	}

	public double getAvailableTime() {
		return this.availableTime;
	}

	public boolean canMove(Drone drone) {
		if (drone.getAddTime() >= this.availableTime) {
			this.isBusy = true;
			return true;
		}
		return false;
	}

	public void moveDrones() {
		for (Drone drone : this.drones) {
			drone.move();
//			this.uiController.updateDronesPos();
		}
	}

	public String toString() {
		return String.format("The number of drones is %d", this.drones.size());
	}

}
