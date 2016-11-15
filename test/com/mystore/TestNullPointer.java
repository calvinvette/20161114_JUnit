package com.mystore;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestNullPointer {
	@Rule Timeout timeout = Timeout.millis(1000);
	
	@Test(expected = NullPointerException.class)
	public void testNullPointer() throws Throwable {
		Grocery soap = new DishSoap();
		try {
			assertTrue(soap.getPrice() > 0);
		} catch (AssertionError e) {
			throw e.getCause();
		}
	}

}
