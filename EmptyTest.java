package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Charlie Moreland
 *
 */
class EmptyTest {
	@Test
	void testConstructor() {
		Empty em= new Empty(new Town(5,3),4,2);
		assertEquals(4,em.row);
		assertEquals(2,em.col);
	}

	@Test
	void testWho() {
		Empty em= new Empty(new Town(1,1),0,0);
		assertEquals(State.EMPTY, em.who());
	}
	@Test
	void testtoString() {
		Empty em= new Empty(new Town(1,1),0,0);
		assertEquals("E", em.toString());
	}
	@Test
	void testNext() {
		try {
		Town t= new Town("ISP4x4.txt");
		TownCell cell= t.grid[1][0];
		cell=cell.next(t);
		assertEquals(State.CASUAL, cell.who());
		}
		catch(IOException e){
			
		}
		
	}

}
