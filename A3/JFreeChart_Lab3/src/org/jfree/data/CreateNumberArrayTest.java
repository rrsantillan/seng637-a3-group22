package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jmock.*;
import org.junit.*;

public class CreateNumberArrayTest {
	private double[] data;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		data = new double[]{1.1, 2.2, 3.3};
	}
    
    // Test to ensure that a null value is not permitted.
    @Test(expected = IllegalArgumentException.class)
    public void testNullException() {
        double[] data = null;
        DataUtilities.createNumberArray(data);
    }
    
    // Test to verify that a valid input returns a non-null array.
    @Test
    public void testReturnsArray() {
        Number[] result = DataUtilities.createNumberArray(data);
        assertNotNull(result);
    }
    
    // Test to verify that a valid input returns an array with the correct length.
    @Test
    public void testArrayLength() {
        Number[] result = DataUtilities.createNumberArray(data);
        assertEquals(data.length, result.length);
    }
    
    // Test to verify that a valid input returns an array with correct values.
    @Test
    public void testArrayValues() {
        Number[] result = DataUtilities.createNumberArray(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], result[i]);
        }
    }
    
    // Test to verify that a valid input at the first index returns the correct values.
    @Test
    public void testFirstIndex() {
        Number[] result = DataUtilities.createNumberArray(data);
	if (data.length == 0) {
        	assertEquals(0, result.length);
    	} else {
        	assertEquals(data[0], result[0]);
    	}
    }
 
    // Test to verify that a valid input at the middle index position returns the correct values.
    @Test
    public void testMiddleIndex() {
        Number[] result = DataUtilities.createNumberArray(data);
	if (data.length == 0) {
        	assertEquals(0, result.length);
    	} else {
        	assertEquals(data[data.length / 2], result[result.length / 2]);
    	}
    }
 
    // Test to verify that a valid input at the last index position returns the correct values.
    @Test
    public void testLastIndex() {
        Number[] result = DataUtilities.createNumberArray(data);
	if (data.length == 0) {
		assertEquals(0, result.length);
    	} else {
        	assertEquals(data[data.length - 1], result[result.length - 1]);
    	}
    }
 
    // Test to verify that a large input returns an array with the correct length.
    @Test
    public void testLargeArrayLength() {
        double[] data = new double[1000];
        for (int i = 0; i < 1000; i++) {
            data[i] = i * 0.5;
        }
        Number[] result = DataUtilities.createNumberArray(data);
        assertEquals(data.length, result.length);
    }
    
    // Test to verify that a large input returns an array with correct values.
    @Test
    public void testLargeArrayValues() {
        double[] data = new double[1000];
        for (int i = 0; i < 1000; i++) {
            data[i] = i * 0.5;
        }
        Number[] result = DataUtilities.createNumberArray(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], result[i]);
        }
    }
    
    // Test to verify that a valid integer input returns an array with the correct length.
    @Test
    public void testIntArrayLength() {
        double[] data = {1, 2, 3, 4, 5};
        Number[] result = DataUtilities.createNumberArray(data);
        assertEquals(data.length, result.length);
    }

    // Test to verify that an array with zero values returns an array with correct values.
    @Test
    public void testZeroValues() {
        double[] data = {0.0, 0.0, 0.0};
        Number[] result = DataUtilities.createNumberArray(data);
        
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], result[i]);
        }
    }
}
