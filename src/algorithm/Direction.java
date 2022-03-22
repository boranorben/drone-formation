package algorithm;

/**
 * Sixteen points direction of Drones.
 * 
 * @author Issaree Srisomboon
 *
 */
public enum Direction {
	/**
	 * North
	 */
	N(0, 1),

	/**
	 * North North East
	 */
	NNE(0.5, 1),

	/**
	 * North East
	 */
	NE(1, 1),

	/**
	 * East North East
	 */
	ENE(1, 0.5),

	/**
	 * East
	 */
	E(1, 0),
	/**
	 * East South East
	 */
	ESE(1, -0.5),

	/**
	 * South East
	 */
	SE(1, -1),

	/**
	 * South South East
	 */
	SSE(0.5, -1),

	/**
	 * South
	 */
	S(0, -1),

	/**
	 * South South West
	 */
	SSW(-0.5, -1),

	/**
	 * 
	 */
	SW(-1, -1),

	/**
	 * West South West
	 */
	WSW(-1, -0.5),

	/**
	 * West
	 */
	W(-1, 0),

	/**
	 * West North West
	 */
	WNW(-1, 0.5),

	/**
	 * North West
	 */
	NW(-1, 1),

	/**
	 * North North West
	 */
	NNW(-0.5, 1);

	public final double offsetX;
	public final double offsetY;

	/**
	 * Constructor of Direction with offset movement parameters X and Y.
	 * 
	 * @param offsetX
	 * @param offsetY
	 */
	private Direction(double offsetX, double offsetY) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}
}
