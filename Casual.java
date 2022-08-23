package edu.iastate.cs228.hw1;

/**
 * 
 * @author Charlie Moreland
 * 
 *
 */
public class Casual extends TownCell {
	/**
	 * 
	 * @param plain
	 * @param r
	 * @param c
	 * constructs a Towncell of the child class
	 */
	public Casual(Town plain, int r, int c) {
		super(plain, r, c);
	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public State who() {
		return State.CASUAL;
	}

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public TownCell next(Town tNew) {
		this.census(nCensus);
		if (nCensus[EMPTY] + nCensus[OUTAGE] <= 1) {
			return new Reseller(tNew, row, col);
		} else if (nCensus[RESELLER] > 0) {
			return new Outage(tNew, row, col);
		} else if (nCensus[STREAMER] > 0) {
			return new Streamer(tNew, row, col);
		} else if (nCensus[CASUAL] >=5) {
			return new Streamer(tNew, row, col);
		} else {
			return new Casual(tNew, row, col);
		}
	}
/**
 * @return the TownCell converted to its String
 */
	@Override
	public String toString() {
		String s = "C";
		return s;
	}
}
