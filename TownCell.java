package edu.iastate.cs228.hw1;

/**
 * 
 * @author Charlie Moreland 
 * 
 *
 */
public abstract class TownCell {

	protected Town plain;
	protected int row;
	protected int col;

	// constants to be used as indices.
	protected static final int RESELLER = 0;
	protected static final int EMPTY = 1;
	protected static final int CASUAL = 2;
	protected static final int OUTAGE = 3;
	protected static final int STREAMER = 4;

	public static final int NUM_CELL_TYPE = 5;

	// Use this static array to take census.
	public static final int[] nCensus = new int[NUM_CELL_TYPE];
/**
 * 
 * @param p Town
 * @param r row
 * @param c column
 * constructs a TownCell of Town row and column
 */
	public TownCell(Town p, int r, int c) {
		plain = p;
		row = r;
		col = c;
	}

/**
 * 
 * @param t
 * @param row
 * @param col
 * @return Town which is the neighborhood of the parameter TownCell
 */
	public Town getNeighbors(Town t, int row, int col) {
		//Calculates the column and row of the new subarray neighborhood
		int colMax, colMin, rowMax, rowMin;
		if (col - 1 < 0) {
			colMin = 0;
		} else {
			colMin = col - 1;
		}
		if (col + 1 > plain.getWidth() - 1) {
			colMax = col;
		} else {
			colMax = col + 1;
		}
		if (row - 1 < 0) {
			rowMin = 0;
		} else {
			rowMin = row - 1;
		}
		if (row + 1 > plain.getLength() - 1) {
			rowMax = row;
		} else {
			rowMax = row + 1;
		}
		//fills up the neighborhood with what TownCells the town had in those index positions
		Town neighborhood = new Town(rowMax - rowMin+1, colMax - colMin+1);
		for (int subRow = rowMin, i = 0; subRow < rowMax+1; subRow++, i++) {
			for (int subCol = colMin, j = 0; subCol < colMax+1; subCol++, j++) {
				neighborhood.grid[i][j] = t.grid[subRow][subCol];
			}
		}
		return neighborhood;
	}

	/**
	 * Checks all neigborhood cell types in the neighborhood. Refer to homework pdf
	 * for neighbor definitions (all adjacent neighbors excluding the center cell).
	 * Use who() method to get who is present in the neighborhood
	 * 
	 * @param counts of all customers
	 */
	public void census(int nCensus[]) {
		// zero the counts of all customers
		nCensus[RESELLER] = 0;
		nCensus[EMPTY] = 0;
		nCensus[CASUAL] = 0;
		nCensus[OUTAGE] = 0;
		nCensus[STREAMER] = 0;
		//iterates through the neighborhood and sums up all of the different kinds of TownCells
		Town t= getNeighbors(this.plain,this.row,this.col);
		for (int r = 0; r < t.getLength(); r++) {
			for (int c = 0; c < t.getWidth(); c++) {
				State status = t.grid[r][c].who();
				if (status == State.RESELLER) {
					nCensus[RESELLER]++;
				} else if (status == State.EMPTY) {
					nCensus[EMPTY]++;
				} else if (status == State.OUTAGE) {
					nCensus[OUTAGE]++;
				} else if (status == State.CASUAL) {
					nCensus[CASUAL]++;
				} else if (status == State.STREAMER) {
					nCensus[STREAMER]++;
				}
			}
		}
		//These if else statements are to remove 1 from the State of the cell whose neighborhood we just counted
		//Since we counted the whole neighborhood and did not exclude the cell whose neighborhood it is
		State status = this.who();
		if (status == State.RESELLER) {
			nCensus[RESELLER]--;
		} else if (status == State.EMPTY) {
			nCensus[EMPTY]--;
		} else if (status == State.OUTAGE) {
			nCensus[OUTAGE]--;
		} else if (status == State.CASUAL) {
			nCensus[CASUAL]--;
		} else if (status == State.STREAMER) {
			nCensus[STREAMER]--;
		}
	}

	/**
	 * Gets the identity of the cell.
	 * 
	 * @return State
	 */
	public abstract State who();

	/**
	 * Determines the cell type in the next cycle.
	 * 
	 * @param tNew: town of the next cycle
	 * @return TownCell
	 */
	public abstract TownCell next(Town tNew);
}
