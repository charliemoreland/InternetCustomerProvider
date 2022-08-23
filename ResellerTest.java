package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Charlie Moreland
 *
 */
class ResellerTest {

	@Test
	void testConstructor() {
		Reseller res= new Reseller(new Town(5,3),4,2);
		assertEquals(4,res.row);
		assertEquals(2,res.col);
	}

	@Test
	void testWho() {
		Reseller res= new Reseller(new Town(1,1),0,0);
		assertEquals(State.RESELLER, res.who());
	}
	@Test
	void testtoString() {
		Reseller res= new Reseller(new Town(1,1),0,0);
		assertEquals("R", res.toString());
	}
	@Test
	void testNext() {
		try {
		Town t= new Town("ISP4x4.txt");
		TownCell cell= t.grid[0][1];
		cell=cell.next(t);
		assertEquals(State.EMPTY, cell.who());
		}
		catch(IOException e){
			
		}
		
	}

}
