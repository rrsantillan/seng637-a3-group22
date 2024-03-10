package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class GetLowerBoundTest {

	 private Range exampleRange;
	 private Range largeRange;
	 private Range illegalRange;
	    @BeforeClass public static void setUpBeforeClass() throws Exception {
	    }


	    @Before
	    public void setUp() throws Exception { 
	    	exampleRange = new Range(-10, 10);
	    	largeRange = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
	    }
	    
	    @Test
	    public void lowerBoundShouldBeNegativeTen() {
	    	assertEquals("The lower bound of the list should be -1.", -10.0, exampleRange.getLowerBound(),0d);
	    }
	    @Test
	    public void lowerBoundWithLargeRange() {
	        assertEquals("The lower bound should handle Double.MAX_VALUE correctly.", -Double.MAX_VALUE, largeRange.getLowerBound(), 0d);
	    }
	    
	    @Test(expected = IllegalArgumentException.class)
	    public void shouldThrowExceptionWhenLowerIsGreaterThanUpper() {
	        illegalRange = new Range(1, -1);
	        illegalRange.getLowerBound();
	    }

	    @After
	    public void tearDown() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
	}
