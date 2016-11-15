package com.mystore;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDishSoap {
	DishSoap dishSoap;
	private static Map<Integer, Integer> truthTable;	
	
	@BeforeClass
	public static void beforeAllTests() {
		// Read this from a spreadsheet later...
		// Use CSV/TSV ideally or Apache POI if it's an Excel spreadsheet
		truthTable = new HashMap<>();
		truthTable.put(1, 289);
		truthTable.put(2, 289*2);
		truthTable.put(3, 289*3);
		truthTable.put(4, 289*4);
		truthTable.put(5, 289*5);
		truthTable.put(6, 289*6);
		truthTable.put(7, 289*7);
		truthTable.put(8, 289*8);
		truthTable.put(9, 289*9);
		truthTable.put(10, 289*10);
		truthTable.put(11, 289*11);
		truthTable.put(12, 289*12);
	}

	@Before
	public void setup() {
		dishSoap = new DishSoap();
	}

	@After
	public void tearDown() {
		dishSoap = null;
	}

	@AfterClass 
	public static void afterAllTest() {
		truthTable = null;
	}
	
	@Test
	public void testDishSoapPrices() {
		for (Map.Entry<Integer, Integer> entry : truthTable.entrySet()) {
			dishSoap.setQuantity(entry.getKey());
			assertEquals("Discount Logic failed @qty:" + entry.getKey(), 
					entry.getValue(), dishSoap.getPrice() 
					);
		}
	}

}
