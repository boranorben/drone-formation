package algorithm;

public class Drone {
	private int id;
	private double dx;
	private double dy;
	private double destDx;
	private double destDy;
	private Direction direction;

	public Drone(int id) {
		this.id = id;
		this.dx = 0.0;
		this.dy = 0.0;
		this.destDx = 0.0;
		this.destDy = 0.0;
		this.direction = Direction.N;
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

	public Direction getDirection() {
		return this.direction;
	}

	public void defineDirection() {
		double diffDx = this.destDx - this.dx;
		double diffDy = this.destDy - this.dy;
		double destDiff = this.destDx - this.destDy;

		if (this.destDx > 0 && this.destDy > 0) {
			this.direction = (diffDx == 0 && diffDy >= 0) ? Direction.N
					: destDiff < 0 ? Direction.NNE : destDiff == 0 ? Direction.NE : Direction.ENE;
		} else if (this.destDx > 0 && this.destDy < 0) {
			this.direction = (diffDy == 0 && diffDx >= 0) ? Direction.E
					: destDiff > 0 ? Direction.ESE : destDiff == 0 ? Direction.SE : Direction.SSE;
		} else if (this.destDx < 0 && this.destDy < 0) {
			this.direction = (diffDx == 0 && diffDy <= 0) ? Direction.S
					: destDiff < 0 ? Direction.SSW : destDiff == 0 ? Direction.SW : Direction.WSW;
		} else if (this.destDx < 0 && this.destDy > 0) {
			this.direction = (diffDy == 0 && diffDx <= 0) ? Direction.W
					: destDiff > 0 ? Direction.WNW : destDiff == 0 ? Direction.NW : Direction.NNW;
		}
	}

	public void move() {
		if (this.dx != this.destDx || this.dy != this.destDy) {
			this.dx += this.direction.offsetX;
			this.dy += this.direction.offsetY;
		}
	}

	public String toString() {
		return String.format("Drone %d at position (%.0f, %.0f) [Destination postion at (%.0f, %.0f)], direction: %s",
				this.id, this.dx, this.dy, this.destDx, this.destDy, this.direction);
	}
}
