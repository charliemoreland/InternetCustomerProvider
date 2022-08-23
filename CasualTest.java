package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Charlie Moreland
 *
 */
class CasualTest {

	@Test
	void testConstructor() {
		Casual cas= new Casual(new Town(5,3),4,2);
		assertEquals(4,cas.row);
		assertEquals(2,cas.col);
	}

	@Test
	void testWho() {
		Casual cas = new Casual(new Town(1,1),0,0);
		assertEquals(State.CASUAL, cas.who());
	}
	@Test
	void testtoString() {
		Casual cas = new Casual(new Town(1,1),0,0);
		assertEquals("C", cas.toString());
	}
	@Test
	void testNext() {
		try {
		Town t= new Town("ISP4x4.txt");
		TownCell cell= t.grid[2][1];
		cell=cell.next(t);
		assertEquals(State.OUTAGE, cell.who());
		}
		catch(IOException e){
			
		}
		
	}
}
