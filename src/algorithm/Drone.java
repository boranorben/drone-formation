package algorithm;

public class Drone {
	private int id;
	private Direction direction;
	private int velocity;
	private int duration;
	
	private double dx;
	private double dy;

	private double addTime;

	public Drone(int id, Direction direction, int velocity, int duration, double addTime) {
		this.id = id;
		this.direction = direction;
		this.velocity = velocity;
		this.duration = duration;
		
		this.dx = 0.0;
		this.dy = 0.0;

		this.addTime = addTime;
	}

	public int getId() {
		return this.id;
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
	
	public double getX() {
		return this.dx;
	}

	public double getY() {
		return this.dy;
	}

	public double getAddTime() {
		return this.addTime;
	}

	public void move() {
		this.dx += (this.direction.offsetX * this.velocity);
		this.dy += (this.direction.offsetY * this.velocity);
	}

	public String toString() {
		return String.format("Drone %d (time added: %.0f) at position (%.0f, %.0f), direction: %s", this.id,
				this.addTime, this.dx, this.dy, this.direction);
	}
}
