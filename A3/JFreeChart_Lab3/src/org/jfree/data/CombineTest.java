package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class CombineTest {

    private Range testRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {testRange = new Range(-10, 10);
    }
    
    // Test cases for the combine(Range, Range) method.
    // Test the combination of two null ranges. The result should be null.
    @Test
    public void testCombineBothRangesNull() {
    	// Define a range by combining two null values.
        Range range = Range.combine(null, null);
        
        // Verify that the resulting range is null.
        assertNull(range);
    }
    
    // Test the combination of a null range with the testRange. The result should be testRange.
    @Test
    public void testCombineFirstRangeNull() {
    	// Define a range by combining null with the testRange.
        Range range = Range.combine(null, testRange);
        
        // Verify that the resulting range is equal to the testRange.
        assertEquals(range, testRange);
    }
    
    // Test the combination of the testRange with a null range. The result should be testRange.
    @Test
    public void testCombineSecondRangeNull() {
    	// Define a range by combining a testRange with null.
        Range range = Range.combine(testRange, null);
        
        // Verify that the resulting range is equal to testRange.
        assertEquals(range, testRange);
    }
    
    // Test the combination of two non-overlapping ranges.
    // *** The documentation does not state how this should be handled.
    @Test
    public void testCombineNonOverlappingRanges() {
    	// Define two ranges that do not overlap.
        Range range1 = new Range(2, 5);
        Range range2 = new Range(7, 10);
        
        // Combine the overlapping ranges.
        Range range = Range.combine(range1, range2);
        
        // Verify the result is null (it is not stated in the documentation what the result should be.
        assertNull(range);
    }

    // Test the combination of two equal ranges. The result should be the same range.
    @Test
    public void testCombineEqualRanges() {
    	// Create a Range object by combining two equal ranges.
    	Range range = Range.combine(testRange, testRange);
    	
    	// Verify that the result is equal to testRange.
    	assertEquals(range, testRange);
    }
    
    // Test the combination of the testRange with a range from UB to maximum double value.
    @Test
    public void testCombineUBToMax() {
    	// Define a newRange from the UB to the maximum double value.
        Range newRange = new Range(10, Double.MAX_VALUE);
        
        // Combine the newRange with the testRange.
        Range range = Range.combine(newRange, testRange);
        
        // Define the expected result.
        Range expected = new Range(-10, Double.MAX_VALUE);
        
        // Verify that the expected output matches the resultant range.
        assertEquals(expected, range);
    }
    
    // Test the combination of the testRange with a range from the minimum double value to LB.
    @Test
    public void testCombineMinToLB() {
    	// Define a newRange from the minimum value to the LB.
        Range newRange = new Range(Double.NEGATIVE_INFINITY, -10);
        
        // Combine the newRange with the testRange.
        Range range = Range.combine(newRange, testRange);
        
        // Define the expected result.
        Range expected = new Range(Double.NEGATIVE_INFINITY, 10);
        
        // Verify that the expected output matches the resultant range.
        assertEquals(expected, range);
    }
    
    // Test the combination of the testRange with ALB.
    @Test
    public void testCombineTestRangeWithALB() {
    	// Define a newRange from the ALB to 100.
        Range newRange = new Range(-9.9, 100);
        
        // Combine the newRange with the testRange.
        Range range = Range.combine(newRange, testRange);
        
        // Define the expected result.
        Range expected = new Range(-10, 100);
        
        // Verify that the expected output matches the resultant range.
        assertEquals(expected, range);
    }
    
 // Test the combination of the testRange with ALB.
    @Test
    public void testCombineTestRangeWithAUB() {
    	// Define a newRange from the AUB to 100.
        Range newRange = new Range(9.9, 100);
        
        // Combine the newRange with the testRange.
        Range range = Range.combine(newRange, testRange);
        
        // Define the expected result.
        Range expected = new Range(-10, 100);
        
        // Verify that the expected output matches the resultant range.
        assertEquals(expected, range);
    }
     
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
