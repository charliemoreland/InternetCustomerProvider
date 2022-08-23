package edu.iastate.cs228.hw1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Charlie Moreland
 *
 */
public class Town {

	private int length, width; // Row and col (first and second indices)
	public TownCell[][] grid;

	/**
	 * Constructor to be used when user wants to generate grid randomly, with the
	 * given seed. This constructor does not populate each cell of the grid (but
	 * should assign a 2D array to it).
	 * 
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		this.length = length;
		this.width = width;
		grid = new TownCell[length][width];
	}

	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of
	 * catching it. Ensure that you close any resources (like file or scanner) which
	 * is opened in this function.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException, IOException {
		FileInputStream stream= new FileInputStream(inputFileName);
		Scanner scan = new Scanner(stream);
		int row = scan.nextInt();
		int col = scan.nextInt();
		grid = new TownCell[row][col];
		length = row;
		width = col;
		String cell = "";
		for (int r = 0; r < length; r++) {
			for (int c = 0; c < width; c++) {
				cell = scan.next();
				if(cell.equals("C")) {
					grid[r][c] = new Casual(this, r, c);
				}
				else if(cell.equals("E")){
					grid[r][c] = new Empty(this, r, c);
				}
				else if(cell.equals("O")) {
					grid[r][c] = new Outage(this, r, c);
				}
				else if(cell.equals("R")) {
					grid[r][c] = new Reseller(this, r, c);
				}
				else {
					grid[r][c] = new Streamer(this, r, c);
				}
			}

		}
		scan.close();
		stream.close();

	}

	/**
	 * Returns width of the grid.
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns length of the grid.
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following
	 * class object: Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		Random rand = new Random(seed);
		int x;
		for (int r = 0; r < length; r++) {
			for (int c = 0; c < width; c++) {
				x = rand.nextInt(5);
				if (x == 0) {
					grid[r][c] = new Reseller(this, r, c);
				} else if (x == 1) {
					grid[r][c] = new Empty(this, r, c);
				} else if (x == 2) {
					grid[r][c] = new Casual(this, r, c);
				} else if (x == 3) {
					grid[r][c] = new Outage(this, r, c);
				} else {
					grid[r][c] = new Streamer(this, r, c);
				}

			}
		}
	}

	/**
	 * Output the town grid. For each square, output the first letter of the cell
	 * type. Each letter should be separated either by a single space or a tab. And
	 * each row should be in a new line. There should not be any extra line between
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		for (int r = 0; r < length; r++) {
			for (int c = 0; c < width; c++) {
				s += grid[r][c] + "\t";
			}
			s += "\n";
		}
		return s;
	}
}
