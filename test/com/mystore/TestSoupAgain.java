package com.mystore;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
//You can use * for both CoreMatchers and Matchers,
//but apparently there's then a conflict between two
//definitions of "is". 
//
//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSoupAgain {
	Soup soup;
	private static Map<Integer, Integer> truthTable;	
	
	@BeforeClass
	public static void beforeAllTests() {
		// Read this from a spreadsheet later...
		// Use CSV/TSV ideally or Apache POI if it's an Excel spreadsheet
		truthTable = new HashMap<>();
		truthTable.put(1, 125);
		truthTable.put(2, 250);
		truthTable.put(3, 300);
		truthTable.put(4, 425);
		truthTable.put(5, 550);
		truthTable.put(6, 600);
		truthTable.put(7, 725);
		truthTable.put (8, 850);
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
	public void testNullPointerException() {
		Soup s = new Soup();
		assertEquals("Should be the same!", s, s);
		assertThat("Should be the same!", s, is(s));
		assertThat("Should be the same!", s, equalTo(s));
		assertThat("Should be the same!", s, is(equalTo(s)));
		assertThat("Should be the same!", s, is(s));
		System.out.println("Done with equals");
//		assertThat("Should be the same!", s, is(not(equalTo(s))));
//		System.out.println("Done with not-equals");
		assertEquals(3.14159265, 3.14, 0.01);
		assertThat(30, is(30));
		
		List<Integer> ages = new Vector<>();
		ages.add(20);
		ages.add(30);
		ages.add(40);
//		assertThat(age, );
		assertThat("  Now  is 				the     time   ", 
				equalToIgnoringWhiteSpace("  Now		 is the time   "));
		assertThat(ages, 
				not(
						hasItem(
								lessThan(
										new Integer(18)
								)
						)
					)
				);
		try {
			s.getPrice();
			fail("Never should get here! Should have thrown NPE!");
		} catch (NullPointerException e) {
			assertEquals("Should be an NPE Exception", 
					NullPointerException.class, 
					e.getClass());
		}
	}
	
	
//	@Test
//	public void testSoupPrices() {
//		for (Map.Entry<Integer, Integer> entry : truthTable.entrySet()) {
//			soup.setQuantity(entry.getKey());
//			assertEquals("Discount Logic failed @qty:" + entry.getKey(), 
//					entry.getValue(), soup.getPrice() 
//					);
//		}
//	}

}
