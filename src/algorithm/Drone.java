package algorithm;

public class Drone {
	private int id;
	private Direction direction;
	private int velocity;
	private int duration;
	private double dx;
	private double dy;

	public Drone(int id, Direction direction, int velocity, int duration) {
		this.id = id;
		this.direction = direction;
		this.velocity = velocity;
		this.duration = duration;
		this.dx = 0.0;
		this.dy = 0.0;
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

	public Direction getDirection() {
		return this.direction;
	}

	public int getVelocity() {
		return this.velocity;
	}

	public int getDuration() {
		return this.duration;
	}

	public void move() {
//			this.dx += this.direction.offsetX;
//			this.dy += this.direction.offsetY;
	}

	public String toString() {
		return String.format("Drone %d at position (%.0f, %.0f), direction: %s", this.id, this.dx, this.dy,
				this.direction);
	}
}
