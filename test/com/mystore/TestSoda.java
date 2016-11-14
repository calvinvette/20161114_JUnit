package com.mystore;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSoda {
	SodaSixPack ssp;
	private static Map<Integer, Integer> truthTable = new HashMap<>();	
	
	@BeforeClass
	public static void beforeAllTests() {
		// Read this from a spreadsheet later...
		// Use CSV/TSV ideally or Apache POI if it's an Excel spreadsheet
		truthTable.put(1, 350);
		truthTable.put(2, 700);
		truthTable.put(3, 1050);
		truthTable.put(4, 1200);
		truthTable.put(5, 1550);
		truthTable.put(6, 1900);
		truthTable.put(7, 2250);
		truthTable.put(8, 2400);
		truthTable.put(9, 2750);
		truthTable.put(10, 3100);
		truthTable.put(11, 3450);
		truthTable.put(12, 3600);
	}

	@Before
	public void setup() {
		ssp = new SodaSixPack();
	}

	@After
	public void tearDown() {
		ssp = null;
	}

	@AfterClass 
	public static void afterAllTest() {
		truthTable = null;
	}
	
	// BeforeClass
	// Before
	// testSixPackPrices
	// After
	// Before
	// testSixPackDeposits
	// After
	// AfterClass
	
	
	@Test
	public void testSixPackPrices() {
		for (Map.Entry<Integer, Integer> entry : truthTable.entrySet()) {
			ssp.setQuantity(entry.getKey());
			assertEquals("Discount Logic failed @qty:" + entry.getKey(), 
//					new Long(entry.getValue()), new Long(ssp.getPrice())
					entry.getValue(), ssp.getPrice() 
//					entry.getValue(), new Integer(ssp.getPrice()) 
					);
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
