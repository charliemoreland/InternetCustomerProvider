package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Charlie Moreland
 *
 */
class StreamerTest {
	@Test
	void testConstructor() {
		Streamer str= new Streamer(new Town(5,3),4,2);
		assertEquals(4,str.row);
		assertEquals(2,str.col);
	}

	@Test
	void testWho() {
		Streamer str= new Streamer(new Town(1,1),0,0);
		assertEquals(State.STREAMER, str.who());
	}
	@Test
	void testtoString() {
		Streamer str= new Streamer(new Town(1,1),0,0);
		assertEquals("S", str.toString());
	}
	@Test
	void testNext() {
		try {
		Town t= new Town("ISP4x4.txt");
		TownCell cell= t.grid[2][3];
		cell=cell.next(t);
		assertEquals(State.OUTAGE, cell.who());
		}
		catch(IOException e){
			
		}
		
	}

}
