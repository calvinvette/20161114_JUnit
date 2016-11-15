package com.mystore;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class TestSodaWithParametersInCSVFile {
	private static final String SODA_DATA_FILE = "soda_data.csv";
	SodaSixPack ssp;
	private Integer quantity, price;

	public TestSodaWithParametersInCSVFile(Integer quantity, Integer price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

	@Parameters
	public static Collection<Integer[]> buildTruthTable() {
		// Read this from a spreadsheet later...
		// Use CSV/TSV ideally or Apache POI if it's an Excel spreadsheet
		List<Integer[]> data = new Vector<Integer[]>();
		try {
			BufferedReader dataFile = new BufferedReader(new FileReader(SODA_DATA_FILE));
			String line;
			while ((line = dataFile.readLine()) != null) {
				String[] fields = line.split(",");
				Integer[] fieldsAsNumbers = new Integer[fields.length];
				for (int i = 0; i < fields.length; i++) {
					try {
						fieldsAsNumbers[i] = new Integer(fields[i].trim());
					} catch (NumberFormatException e) {
						System.err.println("Column #" + (i+1) + " not an Integer: " + fields[i]);
						fieldsAsNumbers[i] = 0;
					}
				}
				data.add(new Integer[] { fieldsAsNumbers[0], fieldsAsNumbers[1]});
			}
			dataFile.close();
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found: " + SODA_DATA_FILE + e.getMessage());
		} catch (IOException e) {
			System.err.println("IO Exception: " + e.getMessage());
		}
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
