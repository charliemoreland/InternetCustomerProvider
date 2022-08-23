package edu.iastate.cs228.hw1;

import java.util.Scanner;

/**
 * @author Charlie Moreland
 *
 *         The ISPBusiness class performs simulation over a grid plain with
 *         cells occupied by different TownCell types.
 *
 */
public class ISPBusiness {

	/**
	 * Returns a new Town object with updated grid value for next billing cycle.
	 * 
	 * @param tOld: old/current Town object.
	 * @return: New town object.
	 */
	public static Town updatePlain(Town tOld) {
		//Iterates through the old town calling new() on each towncell and putting it in the new town
		Town tNew = new Town(tOld.getLength(),tOld.getWidth());
		for (int r = 0; r < tOld.getLength(); r++) {
			for (int c = 0; c < tOld.getWidth(); c++) {
			tNew.grid[r][c]=tOld.grid[r][c].next(tNew);
			}
		}
		return tNew;
	}
	/**
	 * Returns the profit for the current state in the town grid.
	 * 
	 * @param town
	 * @return p number of casual cells
	 */
	public static int getProfit(Town town) {
		//counts up all of the Casual TownCells in the town
		int p = 0;
		for (int r = 0; r < town.getLength(); r++) {
			for (int c = 0; c < town.getWidth(); c++) {
				if (town.grid[r][c].who() == State.CASUAL) {
					p++;
				}
			}
		}
		return p;
	}

	/**
	 * @throws Exception if user input is not a 1 or 2
	 * @return Town t the newly created town
	 * Asks the user how the would like to create the new town from file or random 
	 */
	public static Town createTown() throws Exception {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("How to populate grid (type 1 or 2): 1: from a file. 2: randomly with seed");
			int x = scan.nextInt();
			if (x == 1) {
				System.out.println("Please enter file path:");
				String name = scan.next();
				Town t = new Town(name);
				return t;
			}
			if (x == 2) {
				System.out.println("Provide rows, cols and seed integer seperated by spaces: ");
				System.out.println();
				int row = scan.nextInt();
				int cols = scan.nextInt();
				int seed = scan.nextInt();
				Town t = new Town(row, cols);
				t.randomInit(seed);
				return t;
			} else {
				throw new Exception("Not a valid input");
			}
		} finally {
			scan.close();
		}
	}
/**
 * 
 * @param t Town to iterate over 12 months
 * @return double the profit % over the 12 months
 * calls update plain 12 times on the same town and adds up the profit and calculates the %
 */
	public static double Iterate(Town t) {
		int profit = 0;
		for (int i = 0; i < 12; i++) {
			profit += getProfit(t);
			t=updatePlain(t);
		}
		double last =100.0 * profit / (t.getLength() * t.getWidth() * 12.0);
		return last;
	}

	/**
	 * Main method. Interact with the user and ask if user wants to specify elements
	 * of grid via an input file (option: 1) or wants to generate it randomly
	 * (option: 2).
	 * 
	 * Depending on the user choice, create the Town object using respective
	 * constructor and if user choice is to populate it randomly, then populate the
	 * grid here.
	 * 
	 * Finally: For 12 billing cycle calculate the profit and update town object
	 * (for each cycle). Print the final profit in terms of %. You should print the
	 * profit percentage with two digits after the decimal point: Example if profit
	 * is 35.5600004, your output should be:
	 *
	 * 35.56%
	 * 
	 * Note that this method does not throw any exception, so you need to handle all
	 * the exceptions in it.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		try {
			Town t = createTown();
			System.out.print(String.format("%.2f", Iterate(t)));
			System.out.println("%");
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}
}
