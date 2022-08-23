package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Charlie Moreland
 *
 */
class TownTest {

	@Test
	void testConstructor() {
		Town t= new Town(4,3);
		assertEquals(4,t.getLength());
		assertEquals(3,t.getWidth());
	}
	@Test
	void testConstructorOther() {
		try {
		Town t= new Town("ISP4x4.txt");
		assertEquals(4,t.getLength());
		assertEquals(4,t.getWidth());
		}
		catch(IOException e) {
			
		}
	}
	@Test
	void testLength() {
		Town t= new Town(3,4);
		assertEquals(3,t.getLength());
	}
	@Test
	void testWidth() {
		Town t= new Town(3,4);
		assertEquals(4,t.getWidth());
	}
	@Test
	void testRandom() {
		Town t= new Town(4,4);
		t.randomInit(55);
		assertNotEquals(null,t.grid[0][0]);
	}
	@Test
	void testToString() {
		try {
			Town t= new Town("ISP4x4.txt");
			assertEquals("O\tR\tO\tR\t\nE\tE\tC\tO\t\nE\tS\tO\tS\t\nE\tO\tR\tR\t\n",t.toString());
			}
			catch(IOException e) {
				
			}
			
	}
}
