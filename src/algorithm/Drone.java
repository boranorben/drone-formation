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

//	public void defineDirection() {
//		double diffDx = this.destDx - this.dx;
//		double diffDy = this.destDy - this.dy;
//		double destDiff = this.destDx - this.destDy;
//
//		if (this.destDx > 0 && this.destDy > 0) {
//			this.direction = (diffDx == 0 && diffDy >= 0) ? Direction.N
//					: destDiff < 0 ? Direction.NNE : destDiff == 0 ? Direction.NE : Direction.ENE;
//		} else if (this.destDx > 0 && this.destDy < 0) {
//			this.direction = (diffDy == 0 && diffDx >= 0) ? Direction.E
//					: destDiff > 0 ? Direction.ESE : destDiff == 0 ? Direction.SE : Direction.SSE;
//		} else if (this.destDx < 0 && this.destDy < 0) {
//			this.direction = (diffDx == 0 && diffDy <= 0) ? Direction.S
//					: destDiff < 0 ? Direction.SSW : destDiff == 0 ? Direction.SW : Direction.WSW;
//		} else if (this.destDx < 0 && this.destDy > 0) {
//			this.direction = (diffDy == 0 && diffDx <= 0) ? Direction.W
//					: destDiff > 0 ? Direction.WNW : destDiff == 0 ? Direction.NW : Direction.NNW;
//		}
//	}

	public void move() {
//		if (this.dx != this.destDx || this.dy != this.destDy) {
//			this.dx += this.direction.offsetX;
//			this.dy += this.direction.offsetY;
//		}
	}

	public String toString() {
//		return String.format("Drone %d at position (%.0f, %.0f) [Destination postion at (%.0f, %.0f)], direction: %s",
//				this.id, this.dx, this.dy, this.destDx, this.destDy, this.direction);
		return "";
	}
}
