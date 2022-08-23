package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Charlie Moreland 
 * 
 *
 */
class TownCellTest {
	@Test
	void testConstructor() {
		TownCell t = new Casual(new Town(4,3),3,4);
		assertEquals(4,t.col);
		assertEquals(3,t.row);
	}
	@Test
	void testGetNeighbors() {
		try {
		Town t= new Town("ISP4x4.txt");
		Town newt =t.grid[0][0].getNeighbors(t, 0, 0);
		assertEquals("O\tR\t\nE\tE\t\n",newt.toString());
		}
		catch(IOException e) {
			
		}
	}
		@Test
	void testCensus() {
			try {
				Town t= new Town("ISP4x4.txt");
				TownCell cell= t.grid[0][2];
				cell.census(cell.nCensus);
				assertEquals(1,cell.nCensus[cell.CASUAL]);
				}
				catch(IOException e) {
					
				}
		}
		
	}

