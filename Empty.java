package edu.iastate.cs228.hw1;

/**
 * 
 * @author Charlie Moreland
 * 
 *
 */
public class Empty extends TownCell {
	/**
	 * 
	 * @param plain
	 * @param r
	 * @param c
	 * constructs a Towncell of the child class
	 */
	public Empty(Town plain, int r, int c) {
		super(plain, r, c);
	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public State who() {
		return State.EMPTY;
	}

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public TownCell next(Town tNew) {
		this.census(nCensus);
		if (nCensus[EMPTY] + nCensus[OUTAGE] <=1) {
			return new Reseller(tNew, row, col);
		}
		else {
		return new Casual(tNew, row, col);
		}
	}
	/**
	 * @return the TownCell converted to its String
	 */
	@Override
	public String toString() {
		String s = "E";
		return s;
	}
}
