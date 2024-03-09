package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GetLowerBoundTest {

	 private Range exampleRange;
	    @BeforeClass public static void setUpBeforeClass() throws Exception {
	    }


	    @Before
	    public void setUp() throws Exception { 
	    	exampleRange = new Range(-10, 10);
	    }
	    
	    // Tests if the lower bound of the range matches the expected value of -10.0, ensuring correct initialization of the range object.
	    @Test
	    public void lowerBoundShouldBeNegativeTen() {
	    	assertEquals("The lower bound of the list should be -1.", -10.0, exampleRange.getLowerBound(),0.000000001d);
	    }
	    
	    // Tests a failure scenario where the expected lower bound value is slightly different (-10.00001), which should cause the assertion to fail, highlighting precision issues.
	    @Test
	    public void lowerBoundBLBShouldFail() {
	    	assertEquals("The lower bound of the list should be -1.", -10.00001, exampleRange.getLowerBound(),0.000000001d);
	    }

	    @After
	    public void tearDown() throws Exception {
	    }

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {
	    }
	}
