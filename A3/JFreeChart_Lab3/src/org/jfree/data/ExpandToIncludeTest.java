/**
 * UNDER CONSTRUCTION
 */
package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */
public class ExpandToIncludeTest{
    private Range exampleRange;
    
    /**
     * BLB = -10.1
     * LB = -10
     * ALB = -9.9
     * NOM = 1
     * BUB = 9.9
     * UB = 10
     * AUB = 10.1
     */
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-10, 10);
    }
    
    // Tests if the range is expanded to include a value slightly below the lower bound (-10.1), ensuring correct expansion behavior.
    @Test
    public void expandToIncludeBLBInput() {
    	assertEquals("Failed to expand range to include -10.1.", new Range(-10.1, 10), Range.expandToInclude(exampleRange, -10.1));
    }
    
    // Tests the behavior when attempting to expand the range to include the lower bound value (-10.0), which should not change the range.
    @Test
    public void expandToIncludeLBInput() {
    	assertEquals("Testing to expand range to include -10 - the range shouldn't change.", exampleRange, Range.expandToInclude(exampleRange, -10.0));
    }
    
    // Tests the behavior when attempting to expand the range to include a value just above the lower bound (-9.9), which should not change the range.
    @Test
    public void expandToIncludeALBInput() {
    	assertEquals("Testing to expand range to include -9.9 - the range shouldn't change.", exampleRange, Range.expandToInclude(exampleRange, -9.9));
    }
    
    // Tests the behavior when attempting to expand the range to include a value within the range (1), which should not change the range.
    @Test
    public void expandToIncludeNOMInput() {
    	assertEquals("Testing to expand range to include 1 - the range shouldn't change.", exampleRange, Range.expandToInclude(exampleRange, 1));
    }
    
    // Tests the behavior when attempting to expand the range to include a value just below the upper bound (9.9), which should not change the range.
    @Test
    public void expandToIncludeBUBInput() {
    	assertEquals("Testing to expand range to include -9.9 - the range shouldn't change.", exampleRange, Range.expandToInclude(exampleRange, 9.9));
    }
    
    // Tests the behavior when attempting to expand the range to include the upper bound value (10), which should not change the range.
    @Test
    public void expandToIncludeUBInput() {
    	assertEquals("Testing to expand range to include 10 - the range shouldn't change.", exampleRange, Range.expandToInclude(exampleRange, 10));
    }
    
    // Tests if the range is expanded to include a value slightly above the upper bound (10.1), ensuring correct expansion behavior.
    @Test
    public void expandToIncludeAUBInput() {
    	assertEquals("Failed to expand range to include 10.1.", new Range(-10, 10.1), Range.expandToInclude(exampleRange, 10.1));
    }
    
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


}
