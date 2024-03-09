/**
 * UNDER CONSTRUCTION 
 */

package org.jfree.data;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class CalculateCumulativePercentagesTest {

    private Mockery mockingContext;
    private KeyedValues data;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	
    }
    
    @Before
    public void setUp() throws Exception {
    	mockingContext = new Mockery();
    	data = mockingContext.mock(KeyedValues.class);
    }
    
    // Testing for last KeyedValue result to see if it's 100%
    @Test
    public void getCumulativePercentages_SingleKeyAndValue() {
    	mockingContext.checking(new Expectations() {{
    		allowing(data).getItemCount();	will(returnValue(1));
    		
    		allowing(data).getKey(0); will(returnValue(0));
    		allowing(data).getValue(0); will(returnValue(2));
    	}});
    	
    	// Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(data);
    	
    	// Verify the interactions
        mockingContext.assertIsSatisfied();
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue(0).doubleValue(), 0.00001d);
    }
    
    // Testing for last KeyedValue result to see if it's 100%
    @Test
    public void getCumulativePercentages_SequentialKeysAndValues() {
    	mockingContext.checking(new Expectations() {{
    		allowing(data).getItemCount();	will(returnValue(3));
    		
    		allowing(data).getKey(0); will(returnValue(0));
    		allowing(data).getValue(0); will(returnValue(2));
    		allowing(data).getKey(1); will(returnValue(1));
    		allowing(data).getValue(1); will(returnValue(4));
    		allowing(data).getKey(2); will(returnValue(2));
    		allowing(data).getValue(2); will(returnValue(6));

    	}});
    	
    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(data);
    	
    	// Verify the interactions
        mockingContext.assertIsSatisfied();
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue(2).doubleValue(), 0.00001d);
    }
    
    // Testing for non sequential keys to see if it's 100%
    @Test
    public void getCumulativePercentages_NonSequentialKeysAndValues() {
    	mockingContext.checking(new Expectations() {{
    		allowing(data).getItemCount();	will(returnValue(3));
    		
    		allowing(data).getKey(0); will(returnValue(3));
    		allowing(data).getValue(0); will(returnValue(2));
    		allowing(data).getKey(1); will(returnValue(7));
    		allowing(data).getValue(1); will(returnValue(4));
    		allowing(data).getKey(2); will(returnValue(5));
    		allowing(data).getValue(2); will(returnValue(6));

    	}});
    	
    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(data);
    	
    	// Verify the interactions
        mockingContext.assertIsSatisfied();
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue(2).doubleValue(), 0.00001d);
    }
    
    // Testing for last KeyedValue result to see if it's 100% for negative total
    @Test
    public void getCumulativePercentages_NegativeTotal() {
    	mockingContext.checking(new Expectations() {{
    		allowing(data).getItemCount();	will(returnValue(3));
    		
    		allowing(data).getKey(0); will(returnValue(0));
    		allowing(data).getValue(0); will(returnValue(-50));
    		allowing(data).getKey(1); will(returnValue(1));
    		allowing(data).getValue(1); will(returnValue(1));
    		allowing(data).getKey(2); will(returnValue(2));
    		allowing(data).getValue(2); will(returnValue(10));

    	}});
    	
    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(data);
    	
    	// Verify the interactions
        mockingContext.assertIsSatisfied();
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue(2).doubleValue(), 0.00001d);
    }
    
    // Testing for last KeyedValue result to see if it's 100% for large total
    @Test
    public void getCumulativePercentages_LargePositiveValue() {
    	mockingContext.checking(new Expectations() {{
    		allowing(data).getItemCount();	will(returnValue(3));
    		
    		allowing(data).getKey(0); will(returnValue(0));
    		allowing(data).getValue(0); will(returnValue(10000000));
    		allowing(data).getKey(1); will(returnValue(1));
    		allowing(data).getValue(1); will(returnValue(4));
    		allowing(data).getKey(2); will(returnValue(2));
    		allowing(data).getValue(2); will(returnValue(6));

    	}});
    	
    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(data);
    	
    	// Verify the interactions
        mockingContext.assertIsSatisfied();
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue(2).doubleValue(), 0.00001d);
    }
    
    // Testing for last KeyedValue result for null Value
    @Test
    public void getCumulativePercentages_OneNullValue() {
    	mockingContext.checking(new Expectations() {{
    		allowing(data).getItemCount();	will(returnValue(3));
    		
    		allowing(data).getKey(0); will(returnValue(0));
    		allowing(data).getValue(0); will(returnValue(2));
    		allowing(data).getKey(1); will(returnValue(1));
    		allowing(data).getValue(1); will(returnValue(null));
    		allowing(data).getKey(2); will(returnValue(2));
    		allowing(data).getValue(2); will(returnValue(6));

    	}});
    	
    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(data);
    	
    	// Verify the interactions
        mockingContext.assertIsSatisfied();
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue(2).doubleValue(), 0.00001d);
    }
    
    // Testing for last KeyedValue result for null Key
    @Test(expected = IllegalArgumentException.class)
    public void getCumulativePercentages_OneNullKey() {
    	mockingContext.checking(new Expectations() {{
    		allowing(data).getItemCount();	will(returnValue(3));
    		
    		allowing(data).getKey(0); will(returnValue(null));
    		allowing(data).getValue(0); will(returnValue(2));
    		allowing(data).getKey(1); will(returnValue(1));
    		allowing(data).getValue(1); will(returnValue(4));
    		allowing(data).getKey(2); will(returnValue(2));
    		allowing(data).getValue(2); will(returnValue(6));

    	}});
    	
    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(data);
    	
    	// Verify the interactions
        mockingContext.assertIsSatisfied();
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue(2).doubleValue(), 0.00001d);
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
