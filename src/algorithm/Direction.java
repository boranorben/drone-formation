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
	N(0, 0, 1),

	/**
	 * North North East
	 */
	NNE(22.5, 0.5, 1),

	/**
	 * North East
	 */
	NE(45, 1, 1),

	/**
	 * East North East
	 */
	ENE(57.5, 1, 0.5),

	/**
	 * East
	 */
	E(90, 1, 0),
	/**
	 * East South East
	 */
	ESE(112.5, 1, -0.5),

	/**
	 * South East
	 */
	SE(135, 1, -1),

	/**
	 * South South East
	 */
	SSE(157.5, 0.5, -1),

	/**
	 * South
	 */
	S(180, 0, -1),

	/**
	 * South South West
	 */
	SSW(202.5, -0.5, -1),

	/**
	 * 
	 */
	SW(225, -1, -1),

	/**
	 * West South West
	 */
	WSW(247.5, -1, -0.5),

	/**
	 * West
	 */
	W(270, -1, 0),

	/**
	 * West North West
	 */
	WNW(292.5, -1, 0.5),

	/**
	 * North West
	 */
	NW(315, -1, 1),

	/**
	 * North North West
	 */
	NNW(337.5, -0.5, 1);

	public final double degree;
	public final double offsetX;
	public final double offsetY;

	/**
	 * Constructor of Direction with degree and offset movement parameters X and Y.
	 * 
	 * @param degree
	 * @param offsetX
	 * @param offsetY
	 */
	private Direction(double degree, double offsetX, double offsetY) {
		this.degree = degree;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}
}
