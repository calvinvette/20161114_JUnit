package com.morgan;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Driver {
	SodaSixPack ssp;
	private Map<Integer, Integer> truthTable = new HashMap<>();	

	@Before
	public void setup() {
		ssp = new SodaSixPack();
		truthTable.put(1, 350);
		truthTable.put(2, 700);
		truthTable.put(3, 1050);
		truthTable.put(4, 1200);
		truthTable.put(5, 1550);
	}

	@After
	public void tearDown() {
		ssp = null;
	}

	@Test
	public void testSixPackPrices() {
		for (Map.Entry<Integer, Integer> entry : truthTable.entrySet()) {
			ssp.setQuantity(entry.getKey());
			assertEquals("Discount Logic failed @qty:" + entry.getKey(), 
					new Long(entry.getValue()), new Long(ssp.getPrice()));
		}
	}
	
	@Test
	public void testSixPackDeposits() {
		ssp.setQuantity(1);
		assertEquals("Expected 30 cents for a 6-pack deposit", 6 * 5, ssp.getDeposit());
	}
	
//	@Test
//	public void test1SixPack() {
//		ssp.setQuantity(1);
//		assertEquals(350, ssp.getPrice());
//	}
//
//	@Test
//	public void test2SixPack() {
//		ssp.setQuantity(2);
//		assertEquals(700, ssp.getPrice());
//	}
//
//	@Test
//	public void test3SixPack() {
//		ssp.setQuantity(3);
//		assertEquals(1050, ssp.getPrice());
//	}
//
//	@Test
//	public void test4SixPack() {
//		ssp.setQuantity(4);
//		assertEquals(1200, ssp.getPrice());
//	}
//
//	@Test
//	public void test5SixPack() {
//		ssp.setQuantity(5);
//		assertEquals(1550, ssp.getPrice());
//	}

}
