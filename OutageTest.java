package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Charlie Moreland
 *
 */
class OutageTest {
	@Test
	void testConstructor() {
		Outage ou= new Outage(new Town(5,3),4,2);
		assertEquals(4,ou.row);
		assertEquals(2,ou.col);
	}

	@Test
	void testWho() {
		Outage ou= new Outage(new Town(1,1),0,0);
		assertEquals(State.OUTAGE, ou.who());
	}
	@Test
	void testtoString() {
		Outage ou= new Outage(new Town(1,1),0,0);
		assertEquals("O", ou.toString());
	}
	@Test
	void testNext() {
		try {
		Town t= new Town("ISP4x4.txt");
		TownCell cell= t.grid[3][1];
		cell=cell.next(t);
		assertEquals(State.EMPTY, cell.who());
		}
		catch(IOException e){
			
		}
		
	}
}
