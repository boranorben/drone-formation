package algorithm;

import java.util.ArrayList;

import application.MainSceneController;

public class Base {
	private MainSceneController controller;
	private int areaHeight;
	private int areaWidth;
	private ArrayList<Drone> drones;

	public Base(MainSceneController controller, int areaHeight, int areaWidth, int numDrones) {
		this.controller = controller;
		this.areaHeight = areaHeight;
		this.areaWidth = areaWidth;
		this.drones = new ArrayList<Drone>(numDrones);

		for (int i = 0; i < numDrones; i++) {
			this.drones.add(new Drone(i));
		}

		this.calculateDest();

		for (Drone drone : this.drones) {
			System.out.println(drone.toString());
		}
	}

	public ArrayList<Drone> getDrones() {
		return this.drones;
	}

	public String toString() {
		return String.format("The size of area is height: %d, width: %d and the number of drones is %d",
				this.areaHeight, this.areaWidth, this.drones.size());
	}

	public void moveDrones() {
		for (Drone drone : this.drones) {
			drone.move();
			this.controller.updateDronesPos();
		}
	}

	private void calculateDest() {
		int row = (int) Math.round(Math.sqrt(this.drones.size()));
		int col = 0;
		final int droneSize = 25;

		if (this.drones.size() % row == 0) {
			col = this.drones.size() / row;
		} else {
			col = (this.drones.size() / row) + 1;
		}

		// y = height = row / x = width = column
		int heightDist = (this.areaHeight - droneSize) / (row + 1);
		int widthDist = (this.areaWidth - droneSize) / (col + 1);

		for (Drone drone : this.drones) {
			drone.setDestX(widthDist * ((drone.getId() % col) + 1));
			drone.setDestY(heightDist * ((drone.getId() / row) + 1));
			drone.defineDirection();
		}
	}

//	private void errorFunc() {
//	}

}
