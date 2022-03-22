package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.MainSceneController;

public class Base {
	private MainSceneController controller;
	private ArrayList<Drone> drones;

	public Base(MainSceneController controller) {
		this.controller = controller;
		this.drones = new ArrayList<Drone>();

//		this.calculateDest();
//
//		for (Drone drone : this.drones) {
//			System.out.println(drone.toString());
//		}
	}

	public void addDrone(int id, double degree, int velocity, int duration) {
		List<Direction> dValue = Arrays.asList(Direction.values());
		Direction direction = null;
		for (Direction d : dValue) {
			if (d.degree == degree) {
				direction = d;
				break;
			}
		}
		this.drones.add(new Drone(id, direction, velocity, duration));
	}

	public ArrayList<Drone> getDrones() {
		return this.drones;
	}

	public String toString() {
//		return String.format("The size of area is height: %d, width: %d and the number of drones is %d",
//				this.areaHeight, this.areaWidth, this.drones.size());
		return "";
	}

	public void moveDrones() {
//		for (Drone drone : this.drones) {
//			drone.move();
//			this.controller.updateDronesPos();
//		}
	}

	private void calculateDest() {
//		int row = (int) Math.round(Math.sqrt(this.drones.size()));
//		int col = 0;
//		final int droneSize = 25;
//
//		if (this.drones.size() % row == 0) {
//			col = this.drones.size() / row;
//		} else {
//			col = (this.drones.size() / row) + 1;
//		}
//
//		// y = height = row / x = width = column
//		int heightDist = (this.areaHeight - droneSize) / (row + 1);
//		int widthDist = (this.areaWidth - droneSize) / (col + 1);
//
//		for (Drone drone : this.drones) {
//			drone.setDestX(widthDist * ((drone.getId() % col) + 1));
//			drone.setDestY(heightDist * ((drone.getId() / row) + 1));
////			drone.defineDirection();
//		}
	}

//	private void errorFunc() {
//	}

}
