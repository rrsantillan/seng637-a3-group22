package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Test;

public class CreateNumberArray2DTest {
	@Test
    public void calculateColumnTotalForTwoValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(2));
            oneOf(values).getValue(0, 0);
            will(returnValue(7.5));
            oneOf(values).getValue(1, 0);
            will(returnValue(2.5));
        }});

        // exercise
        double result = DataUtilities.calculateColumnTotal(values, 0);

        // verify
        assertEquals(10.0, result, .000000001d);

        // tear-down: NONE in this test method
    }
    
    // Tests for createNumberArray2D() method.
    
    // Test to ensure that a null value is not permitted.
    @Test(expected = IllegalArgumentException.class)
    public void createNumberArray2DNullException() {
    	// Define a null double[][] object.
    	double[][] data = null;
    	
    	// Apply the createNumberArray2D() method on the null data variable.
    	// As per the documentation, this should return 
    	DataUtilities.createNumberArray2D(data);
    }
    
    // Test to check that the correct Number array is created from a valid 2x6 double[][] object.
    @Test
    public void createNumberArray2DValidInputReturnsArray() {
    	// Define a valid double[][] object.
    	double[][] data = {{1.1, 2.2, 3.3}, {4.4, 5.5, 6.6}};
    	
    	// Create the Number array.
    	Number[][] result = DataUtilities.createNumberArray2D(data);
    	
    	// Verify that the result is non-null.
    	assertNotNull(result);
    	
    	// Verify that the result is of the correct dimensions.
    	assertEquals(2, result.length);
        assertEquals(3, result[0].length);
        assertEquals(3, result[1].length);
    	
    	// Verification of each entry in Number[][].
        assertEquals(1.1, result[0][0].doubleValue(), 0.000001);
        assertEquals(2.2, result[0][1].doubleValue(), 0.000001);
        assertEquals(3.3, result[0][2].doubleValue(), 0.000001);
        assertEquals(4.4, result[1][0].doubleValue(), 0.000001);
        assertEquals(5.5, result[1][1].doubleValue(), 0.000001);
        assertEquals(6.6, result[1][2].doubleValue(), 0.000001);  
    }
    
    // Test to check that the correct Number array is created from a 1x1 double[][] object.
    @Test
    public void createNumberArray2DSingleElementReturnsArray() {
    	// Define a valid double[][] object.
    	double[][] data = {{1.1}};
    	
    	// Create the Number array.
    	Number[][] result = DataUtilities.createNumberArray2D(data);
    	
    	// Verify that the result is non-null.
    	assertNotNull(result);
    	
    	// Verify that the result is of the correct dimensions.
    	assertEquals(1, result.length);
    	assertEquals(1, result[0].length);
    	
    	// Verify that the single-entry is the correct value.
    	assertEquals(1.1, result[0][0].doubleValue(), 0.000001);
    }
    
    // Test to check that an empty Number array is created from a empty double[][] object.
    @Test
    public void createNumberArray2DEmptyArrayReturnsArray() {
    	// Define an empty double[][] object.
    	double[][] data = {};
    	
    	// Create the Number array.
    	Number[][] result = DataUtilities.createNumberArray2D(data);
    	
    	// Verify that the result is non-null.
    	assertNotNull(result);
    	
    	// Verify that the array is empty.
    	assertEquals(0, result.length);
    }
    
    // Test to check that the correct Number array is created from a valid 100x100 double[][] object.
    @Test
    public void createNumberArray2DLargeInputReturnsArray() {
    	// Define a valid double[][] object.
    	double[][] data = new double[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                data[i][j] = i + j;
            }
        }
    	
    	// Create the Number array.
    	Number[][] result = DataUtilities.createNumberArray2D(data);
    	
    	// Verify that the result is non-null.
    	assertNotNull(result);
    	
    	// Verify that the result is of the correct dimensions.
    	 assertEquals(100, result.length);
    	 for (int i = 0; i < 100; i++) { 
    		 assertEquals(100, result[i].length);
    	 }
    	
    	// Verification of each entry in Number[][].
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                assertEquals(data[i][j], result[i][j].doubleValue(), 0.000001);
            }
        }
    }  
    
    // Test to check that the correct Number array is created from a valid horizontal 1x5 double[][] object.
    @Test
    public void createNumberArray2DValidHorizontalInputReturnsArray() {
    	// Define a valid double[][] object.
    	double[][] data = {{1.1, 2.2, 3.3, 4.4, 5.5}};
    	
    	// Create the Number array.
    	Number[][] result = DataUtilities.createNumberArray2D(data);
    	
    	// Verify that the result is non-null.
    	assertNotNull(result);
    	
    	// Verify that the result is of the correct dimensions.
    	assertEquals(1, result.length);
        assertEquals(5, result[0].length);
    	
    	// Verification of each entry in Number[][].
        assertEquals(1.1, result[0][0].doubleValue(), 0.000001);
        assertEquals(2.2, result[0][1].doubleValue(), 0.000001);
        assertEquals(3.3, result[0][2].doubleValue(), 0.000001);
        assertEquals(4.4, result[0][3].doubleValue(), 0.000001);
        assertEquals(5.5, result[0][4].doubleValue(), 0.000001);
    } 
    
 // Test to check that the correct Number array is created from a valid vertical 5x1 double[][] object.
    @Test
    public void createNumberArray2DValidVerticalInputReturnsArray() {
    	// Define a valid double[][] object.
    	double[][] data = {{1.1}, {2.2}, {3.3}, {4.4}, {5.5}};
    	
    	// Create the Number array.
    	Number[][] result = DataUtilities.createNumberArray2D(data);
    	
    	// Verify that the result is non-null.
    	assertNotNull(result);
    	
    	// Verify that the result is of the correct dimensions.
    	assertEquals(5, result.length);
        assertEquals(1, result[0].length);
    	
    	// Verification of each entry in Number[][].
        assertEquals(1.1, result[0][0].doubleValue(), 0.000001);
        assertEquals(2.2, result[1][0].doubleValue(), 0.000001);
        assertEquals(3.3, result[2][0].doubleValue(), 0.000001);
        assertEquals(4.4, result[3][0].doubleValue(), 0.000001);
        assertEquals(5.5, result[4][0].doubleValue(), 0.000001);
    }  
}
