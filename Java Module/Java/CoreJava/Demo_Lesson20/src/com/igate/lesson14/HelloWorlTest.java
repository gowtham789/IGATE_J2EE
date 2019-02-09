package com.igate.lesson14;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class HelloWorlTest {
	
	@Test
	public void testSay()
	{
		HelloWorld hello=new HelloWorld();
		
		assertEquals("Unexpected Result","Hello World!", hello.say());
	}
}
