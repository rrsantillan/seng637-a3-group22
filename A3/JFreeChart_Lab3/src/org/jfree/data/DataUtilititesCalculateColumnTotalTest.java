package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.*;
import org.jmock.Mockery;
import org.jmock.Expectations;

public class DataUtilititesCalculateColumnTotalTest extends DataUtilities {
	private DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	
    @Test
    public void calculateColumnTotalForTwoValues() {

        this.values.addValue(7.5, 0, 0);
        this.values.addValue(2.5, 1, 0);

        double result = DataUtilities.calculateColumnTotal(values, 0);
        this.values.clear();

        assertEquals(10.0, result, .000000001d);

    }
    
    @Test
    public void calculateColumnTotalForThreeValuesFirstColumn() {
        this.values.addValue(7.5, 0, 0);
        this.values.addValue(2.5, 1, 0);
        this.values.addValue(5, 2, 0);

        double result = DataUtilities.calculateColumnTotal(values, 0);
        this.values.clear();

        assertEquals(15.0, result, .000000001d);

    }
    
    @Test
    public void calculateColumnTotalForThreeValuesMiddleColumn() {
    	
        this.values.addValue(7.5, 0, 0);
        this.values.addValue(2.5, 1, 0);
        this.values.addValue(5, 2, 0);
    	
        this.values.addValue(7.5, 0, 1);
        this.values.addValue(2.5, 1, 1);
        this.values.addValue(5, 2, 1);

        double result = DataUtilities.calculateColumnTotal(values, 1);
        this.values.clear();

        assertEquals(15.0, result, .000000001d);

    }
    
    @Test
    public void calculateColumnTotalForThreeValuesLastColumn() {
    	
        this.values.addValue(7.5, 0, 0);
        this.values.addValue(2.5, 1, 0);
        this.values.addValue(5, 2, 0);
    	
        this.values.addValue(7.5, 0, 1);
        this.values.addValue(2.5, 1, 1);
        this.values.addValue(5, 2, 1);
    	
        this.values.addValue(7.5, 0, 2);
        this.values.addValue(2.5, 1, 2);
        this.values.addValue(5, 2, 2);

        double result = DataUtilities.calculateColumnTotal(values, 2);
        this.values.clear();

        assertEquals(15.0, result, .000000001d);

    }
    
    @Test
    public void calculateColumnTotalWithMaxValue() {
    	
        this.values.addValue(Double.MAX_VALUE, 0, 0);
        this.values.addValue(5, 1, 0);
        this.values.addValue(-5, 2, 0);

        double result = DataUtilities.calculateColumnTotal(values, 0);
        this.values.clear();

        assertEquals(Double.MAX_VALUE, result, .000000001d);

    }
    
    @Test
    public void calculateColumnTotalWithMinValue() {
    	
        this.values.addValue(Double.MIN_VALUE, 0, 0);
        this.values.addValue(5, 1, 0);
        this.values.addValue(-5, 2, 0);

        double result = DataUtilities.calculateColumnTotal(values, 0);
        this.values.clear();

        assertEquals(Double.MIN_VALUE, result, .000000001d);
    }
    
    @Test
    public void calculateColumnTotalWithSumOf0() {
    	
        this.values.addValue(0, 0, 0);
        this.values.addValue(5, 1, 0);
        this.values.addValue(-5, 2, 0);

        double result = DataUtilities.calculateColumnTotal(values, 0);
        this.values.clear();

        assertEquals(0, result, .000000001d);
    }
    
    @Test
    public void calculateColumnTotalForTwoNegativeValues() {
    	
        this.values.addValue(0, 0, 0);
        this.values.addValue(-7.5, 1, 0);
        this.values.addValue(-2.5, 2, 0);

        double result = DataUtilities.calculateColumnTotal(values, 0);
        this.values.clear();

        assertEquals(-10.0, result, .000000001d);
    }
    
    @Test
    public void calculateColumnTotalWithNull() {

        this.values.addValue(null, 0, 0);
        this.values.addValue(2.5, 1, 0);

        double result = DataUtilities.calculateColumnTotal(values, 0);
        this.values.clear();

        assertEquals(2.5, result, .000000001d);

    }
}
