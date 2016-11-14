package com.mystore;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSoup {
	Soup soup;
	private static Map<Integer, Integer> truthTable = new HashMap<>();	
	
	@BeforeClass
	public static void beforeAllTests() {
		// Read this from a spreadsheet later...
		// Use CSV/TSV ideally or Apache POI if it's an Excel spreadsheet
		truthTable.put(1, 125);
		truthTable.put(2, 250);
		truthTable.put(3, 300);
		truthTable.put(4, 425);
		truthTable.put(5, 550);
		truthTable.put(6, 600);
		truthTable.put(7, 725);
		truthTable.put(8, 850);
		truthTable.put(9, 900);
		truthTable.put(10, 1025);
		truthTable.put(11, 1150);
		truthTable.put(12, 1200);
	}

	@Before
	public void setup() {
		soup = new Soup();
	}

	@After
	public void tearDown() {
		soup = null;
	}

	@AfterClass 
	public static void afterAllTest() {
		truthTable = null;
	}
	
	@Test
	public void testSoupPrices() {
		for (Map.Entry<Integer, Integer> entry : truthTable.entrySet()) {
			soup.setQuantity(entry.getKey());
			assertEquals("Discount Logic failed @qty:" + entry.getKey(), 
					entry.getValue(), soup.getPrice() 
					);
		}
	}

}
