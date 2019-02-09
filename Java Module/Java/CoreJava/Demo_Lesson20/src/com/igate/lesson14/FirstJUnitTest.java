package com.igate.lesson14;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
  public class FirstJUnitTest {
    @Test 
          public void simpleAdd() { 
	   int result = 1; 
	   int expected = 1; 
	   assertEquals(result, expected); 
  } } 
