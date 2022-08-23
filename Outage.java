package edu.iastate.cs228.hw1;

/**
 * 
 * @author Charlie Moreland
 * 
 *
 */
public class Outage extends TownCell {
	/**
	 * 
	 * @param plain
	 * @param r
	 * @param c
	 * constructs a Towncell of the child class
	 */
	public Outage(Town plain, int r, int c) {
		super(plain, r, c);
	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public State who() {
		return State.OUTAGE;
	}

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public TownCell next(Town tNew) {
	return new Empty(tNew, this.row, this.col);
	}
	/**
	 * @return the TownCell converted to its String
	 */
	@Override
	public String toString() {
		String s = "O";
		return s;
	}
}
