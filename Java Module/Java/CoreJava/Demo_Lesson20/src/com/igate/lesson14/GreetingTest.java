package com.igate.lesson14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GreetingTest {
@Test
public void testGreet()
{
	Greeting greeting = new Greeting();
	assertEquals("Unexpected result","WELCOME TO JAVA", greeting.greet());
}
}
