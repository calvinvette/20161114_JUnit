package com.morgan;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMessage {
	private Message message;
	
	@Before
	public void setUp() {
		message = new Message("Hello, World");
	}
	
	@After
	public void tearDown() {
		message = null;
	}
	
	@Test
	public void testMessageCTOR() {
		String expected = "Hello, World";
		
		assertEquals("Didn't get constructor-supplied message back!", 
				expected, message.getMessage());
	}
}
