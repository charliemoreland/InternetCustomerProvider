package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Charlie Moreland
 *
 */
class ISPBusinessTest {

	@Test
	void testgetProfit() {
		ISPBusiness b= new ISPBusiness();
		try {
		Town t= new Town("ISP4x4.txt");
		int x= b.getProfit(t);
		assertEquals(1,x);
		}
		catch(IOException e) {
			
		}
	}
	@Test 
	void testupdatePlain(){
		ISPBusiness b= new ISPBusiness();
		try {
		Town t= new Town("ISP4x4.txt");
		Town newt = b.updatePlain(t);
		assertEquals("E\tE\tE\tE\t\nC\tC\tO\tE\t\nC\tO\tE\tO\t\nC\tE\tE\tE\t\n",newt.toString());
		}
		catch(IOException e) {
			
		}
	}
	@Test
	void testIterate() {
		ISPBusiness b= new ISPBusiness();
		try {
		Town t= new Town("ISP4x4.txt");
		double x=b.Iterate(t);
		assertEquals(27.604166666666668,x);
		}
		catch(IOException e) {
			
		}
	}

}
