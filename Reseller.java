package edu.iastate.cs228.hw1;

/**
 * 
 * @author Charlie Moreland
 * 
 *
 */
public class Reseller extends TownCell {
	/**
	 * 
	 * @param plain
	 * @param r
	 * @param c
	 * constructs a Towncell of the child class
	 */
	public Reseller(Town plain, int r, int c) {
		super(plain, r, c);
	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public State who() {
		return State.RESELLER;
	}

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public TownCell next(Town tNew) {
		this.census(nCensus);
		if (nCensus[CASUAL] <=3) {
			return new Empty(tNew, this.row, this.col);
		} else if (nCensus[EMPTY] >=3) {
			return new Empty(tNew, row, col);
		} else if (nCensus[CASUAL] >=5) {
			return new Streamer(tNew, row, col);
		} else {
			return new Reseller(tNew, row, col);
		}
	}
	/**
	 * @return the TownCell converted to its String
	 */
	@Override
	public String toString() {
		String s = "R";
		return s;
	}
}
