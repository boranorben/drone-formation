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
		if (this.destDx > 0 && this.destDy > 0) {
			if (this.destDx == this.dx && this.destDy >= this.dy) {
				this.direction = Direction.N;
			} else if (this.destDx < this.destDy) {
				this.direction = Direction.NNE;
			} else if (this.destDx == this.destDy) {
				this.direction = Direction.NE;
			} else if (this.destDx > this.destDy) {
				this.direction = Direction.ENE;
			}
		} else if (this.destDx > 0 && this.destDy < 0) {
			if (this.destDy == this.dy && this.destDx >= this.dx) {
				this.direction = Direction.E;
			} else if (this.destDx > this.destDy) {
				this.direction = Direction.ESE;
			} else if (this.destDx == this.destDy) {
				this.direction = Direction.SE;
			} else if (this.destDx < this.destDy) {
				this.direction = Direction.SSE;
			}
		} else if (this.destDx < 0 && this.destDy < 0) {
			if (this.destDx == this.dx && this.destDy <= this.dy) {
				this.direction = Direction.S;
			} else if (this.destDx < this.destDy) {
				this.direction = Direction.SSW;
			} else if (this.destDx == this.destDy) {
				this.direction = Direction.SW;
			} else if (this.destDx > this.destDy) {
				this.direction = Direction.WSW;
			}
		} else if (this.destDx < 0 && this.destDy > 0) {
			if (this.destDy == this.dy && this.destDx <= this.dx) {
				this.direction = Direction.W;
			} else if (this.destDx > this.destDy) {
				this.direction = Direction.WNW;
			} else if (this.destDx == this.destDy) {
				this.direction = Direction.NW;
			} else if (this.destDx < this.destDy) {
				this.direction = Direction.NNW;
			}
		}
	}

	public void move() {
		if (this.dx != this.destDx || this.dy != this.destDy) {
			switch (this.direction) {
			case N:
				this.dy += 1;
				break;
			case NNE:
				this.dx += 0.5;
				this.dy += 1;
				break;
			case NE:
				this.dx += 1;
				this.dy += 1;
				break;
			case ENE:
				this.dx += 1;
				this.dy += 0.5;
				break;
			case E:
				this.dx += 1;
				break;
			case ESE:
				this.dx += 1;
				this.dy -= 0.5;
				break;
			case SE:
				this.dx += 1;
				this.dy -= 1;
				break;
			case SSE:
				this.dx += 0.5;
				this.dy -= 1;
				break;
			case S:
				this.dy -= 1;
				break;
			case SSW:
				this.dx -= 0.5;
				this.dy -= 1;
				break;
			case SW:
				this.dx -= 1;
				this.dy -= 1;
				break;
			case WSW:
				this.dx -= 1;
				this.dy -= 0.5;
				break;
			case W:
				this.dx -= 1;
				break;
			case WNW:
				this.dx -= 1;
				this.dy += 0.5;
				break;
			case NW:
				this.dx -= 1;
				this.dy += 1;
				break;
			case NNW:
				this.dx -= 0.5;
				this.dy += 1;
				break;
			default:
				break;
			}
		}
	}

	public String toString() {
		return String.format("Drone %d at position (%.0f, %.0f) [Destination postion at (%.0f, %.0f)], direction: %s",
				this.id, this.dx, this.dy, this.destDx, this.destDy, this.direction);
	}
}
