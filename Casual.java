package edu.iastate.cs228.hw1;

public class Casual extends TownCell{
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
		getNeighbors(this.plain, this.row, this.col).grid[0][0].census(nCensus);
		if (nCensus[RESELLER] > 0) {
			return new Outage(tNew, row, col);
		}
		else if (nCensus[STREAMER] > 0) {
			return new Streamer(tNew, row, col);
		}
		else if (nCensus[EMPTY] + nCensus[OUTAGE] < 2) {
			return new Reseller(tNew, row, col);
		}
		else if (nCensus[CASUAL] > 4) {
			return new Streamer(tNew, row, col);
		} else {
			return new Casual(tNew, row, col);
		}
	}

	@Override
	public String toString() {
		String s = "C";
		return s;
	}
}
