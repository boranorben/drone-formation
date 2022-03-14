package algorithm;

public class Drone {
	private int id;
	private double dx = 0.0;
	private double dy = 0.0;
	private double destDx = 0.0;
	private double destDy = 0.0;

	public Drone(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public double getX() {
		return this.dx;
	}

	public double getY() {
		return this.dy;
	}

	public double getDestX() {
		return this.destDx;
	}

	public double getDestY() {
		return this.destDy;
	}

	public void setDestX(int dx) {
		this.destDx = dx;
	}

	public void setDestY(int dy) {
		this.destDy = dy;
	}

	public String toString() {
		return String.format("Drone%d at position (%d, %d) [Destination postion at (%d, %d)]", this.id, this.dx,
				this.dy, this.destDx, this.destDy);
	}

	public void move() {
		if (this.dx != this.destDx || this.dy != this.destDy) {
			if (this.dx < this.destDx) {
				this.dx += 0.5;
			} else {
				this.dx -= 0.5;
			}
			if (this.dy < this.destDy) {
				this.dy += 0.5;
			} else {
				this.dy -= 0.5;
			}
		}
	}
}
