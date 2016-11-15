package com.mystore;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSodaWithParameters {
	SodaSixPack ssp;
	private Integer quantity, price;

	public TestSodaWithParameters(Integer quantity, Integer price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

	@Parameters
	public static Collection<Integer[]> buildTruthTable() {
		// Read this from a spreadsheet later...
		// Use CSV/TSV ideally or Apache POI if it's an Excel spreadsheet
		List<Integer[]> data = new Vector<Integer[]>();
		Integer[] row = new Integer[2];
		row[0] = 1;
		row[1] = 350;
		data.add(row);
		data.add(new Integer[] { 2, 700 });
		data.add(new Integer[] { 3, 1050 });
		data.add(new Integer[] { 4, 1200 });
		data.add(new Integer[] { 5, 1550 });
		data.add(new Integer[] { 6, 1900 });
		data.add(new Integer[] { 7, 2250 });
		data.add(new Integer[] { 8, 2400 });
		data.add(new Integer[] { 9, 2750 });
		data.add(new Integer[] { 10, 3100 });
		data.add(new Integer[] { 11, 3450 });
		data.add(new Integer[] { 12, 3600 });
		return data;
	}

	@Before
	public void setup() {
		ssp = new SodaSixPack();
	}

	@After
	public void tearDown() {
		ssp = null;
	}

	@Test
	public void testSixPackPrices() {
		ssp.setQuantity(quantity);
		assertEquals("Discount Logic failed @qty:" + quantity,
				// new Long(entry.getValue()), new Long(ssp.getPrice())
				price, ssp.getPrice()
		// entry.getValue(), new Integer(ssp.getPrice())
		);
	}

	// @Test
	// public void testSixPackDeposits() {
	// ssp.setQuantity(1);
	// assertEquals("Expected 30 cents for a 6-pack deposit", 6 * 5,
	// ssp.getDeposit());
	// }

}
