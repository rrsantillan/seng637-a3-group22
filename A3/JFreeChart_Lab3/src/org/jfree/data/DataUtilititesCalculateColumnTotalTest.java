package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.*;
import org.jmock.Mockery;
import org.jmock.Expectations;

public class DataUtilititesCalculateColumnTotalTest extends DataUtilities {
	
    @Test
    public void calculateColumnTotalForTwoValues() {
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

        double result = DataUtilities.calculateColumnTotal(values, 0);

        assertEquals(10.0, result, .000000001d);

    }
    
    @Test
    public void calculateColumnTotalForThreeValuesFirstColumn() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(3));
            oneOf(values).getValue(0, 0);
            will(returnValue(7.5));
            oneOf(values).getValue(1, 0);
            will(returnValue(2.5));
            oneOf(values).getValue(2, 0);
            will(returnValue(5));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);

        assertEquals(15.0, result, .000000001d);

    }
    
    @Test
    public void calculateColumnTotalForThreeValuesMiddleColumn() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(3));
            oneOf(values).getValue(0, 1);
            will(returnValue(7.5));
            oneOf(values).getValue(1, 1);
            will(returnValue(2.5));
            oneOf(values).getValue(2, 1);
            will(returnValue(5));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 1);

        assertEquals(15.0, result, .000000001d);

    }
    
    @Test
    public void calculateColumnTotalForThreeValuesLastColumn() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(3));
            oneOf(values).getValue(0, 2);
            will(returnValue(7.5));
            oneOf(values).getValue(1, 2);
            will(returnValue(2.5));
            oneOf(values).getValue(2, 2);
            will(returnValue(5));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 2);

        assertEquals(15.0, result, .000000001d);

    }
    
    @Test
    public void calculateColumnTotalWithMaxValue() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(3));
            oneOf(values).getValue(0, 0);
            will(returnValue(Double.MAX_VALUE));
            oneOf(values).getValue(1, 0);
            will(returnValue(5));
            oneOf(values).getValue(2, 0);
            will(returnValue(-5));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);

        assertEquals(Double.MAX_VALUE, result, .000000001d);

    }
    
    @Test
    public void calculateColumnTotalWithMinValue() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(3));
            oneOf(values).getValue(0, 0);
            will(returnValue(Double.MIN_VALUE));
            oneOf(values).getValue(1, 0);
            will(returnValue(5));
            oneOf(values).getValue(2, 0);
            will(returnValue(-5));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);

        assertEquals(Double.MIN_VALUE, result, .000000001d);
    }
    
    @Test
    public void calculateColumnTotalWithSumOf0() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(3));
            oneOf(values).getValue(0, 0);
            will(returnValue(0));
            oneOf(values).getValue(1, 0);
            will(returnValue(5));
            oneOf(values).getValue(2, 0);
            will(returnValue(-5));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);

        assertEquals(0, result, .000000001d);
    }
    
    @Test
    public void calculateColumnTotalForTwoNegativeValues() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(2));
            oneOf(values).getValue(0, 0);
            will(returnValue(-7.5));
            oneOf(values).getValue(1, 0);
            will(returnValue(-2.5));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);

        assertEquals(-10.0, result, .000000001d);
    }
}
