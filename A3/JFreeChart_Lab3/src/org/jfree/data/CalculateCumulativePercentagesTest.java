/**
 * UNDER CONSTRUCTION 
 */

package org.jfree.data;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
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
    private DefaultKeyedValues testDKV;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    	
    }
    
//    @Before
//    public void setUp() throws Exception {
//    	testDKV.clear();
//    	
//    }
    
    // Testing for last KeyedValue result to see if it's 100%
    @Test
    public void getCumulativePercentages_SingleKeyAndValue() {
    	this.testDKV = new DefaultKeyedValues();
    	this.testDKV.addValue("0", 5.0);
    	
    	// Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(this.testDKV);
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue("0").doubleValue(), 0.00001d);
    }
    
    // Testing for last KeyedValue result to see if it's 100%
    @Test
    public void getCumulativePercentages_SequentialKeysAndValues() {
    	this.testDKV = new DefaultKeyedValues();
    	this.testDKV.addValue("0", 5.0);
    	this.testDKV.addValue("1", 6.0);
    	this.testDKV.addValue("2", 7.0);
    	
    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(this.testDKV);
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue("2").doubleValue(), 0.00001d);
    }
    
    // Testing for non sequential keys to see if it's 100%
    @Test
    public void getCumulativePercentages_NonSequentialKeysAndValues() {
    	this.testDKV = new DefaultKeyedValues();
    	this.testDKV.addValue("3", 2.0);
    	this.testDKV.addValue("7", 4.0);
    	this.testDKV.addValue("5", 6.0);
    	
    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(this.testDKV);
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue("5").doubleValue(), 0.00001d);
    }
    
    // Testing for last KeyedValue result to see if it's 100% for negative total
    @Test
    public void getCumulativePercentages_NegativeTotal() {
    	this.testDKV = new DefaultKeyedValues();
    	this.testDKV.addValue("0", -50.0);
    	this.testDKV.addValue("1", 1.0);
    	this.testDKV.addValue("2", 10.0);

    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(this.testDKV);
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue("2").doubleValue(), 0.00001d);
    }
    
    // Testing for last KeyedValue result to see if it's 100% for large total
    @Test
    public void getCumulativePercentages_LargePositiveValue() {
    	this.testDKV = new DefaultKeyedValues();
    	this.testDKV.addValue("0", 10000000.0);
    	this.testDKV.addValue("1", 4.0);
    	this.testDKV.addValue("2", 6.0);

    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(this.testDKV);
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue("2").doubleValue(), 0.00001d);
    }
    
    // Testing for KeyedValue result for null Value
    @Test
    public void getCumulativePercentages_OneNullValue() {
    	this.testDKV = new DefaultKeyedValues();
    	this.testDKV.addValue("0", 2.0);
    	this.testDKV.addValue("1", null);
    	this.testDKV.addValue("2", 6.0);
    	
    	//Exercise
    	KeyedValues resultingKV = DataUtilities.getCumulativePercentages(this.testDKV);
    	
        // Assertion
        assertEquals(1.0, resultingKV.getValue("2").doubleValue(), 0.00001d);
    }
    
 // Testing for null KeyedValues
    @Test(expected = IllegalArgumentException.class)
    public void getCumulativePercentages_NullKV() {
    	KeyedValues data = null;
        DataUtilities.getCumulativePercentages(data);
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
