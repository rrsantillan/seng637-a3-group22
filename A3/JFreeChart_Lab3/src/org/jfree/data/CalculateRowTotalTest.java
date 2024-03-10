package org.jfree.data;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateRowTotalTest {
	private DefaultKeyedValues2D values;
	private DefaultKeyedValues2D valuesMax;
	private DefaultKeyedValues2D valuesMin;
	private DefaultKeyedValues2D valuesNull;

	private DefaultKeyedValues2D valuesSumZero;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.values = new DefaultKeyedValues2D();
		this.values.addValue(7.5, 0, 0);
		this.values.addValue(2.5, 0, 1);
		this.values.addValue(5.0, 0, 2);
		this.values.addValue(7.5, 1, 0);
		this.values.addValue(2.5, 1, 1);
		this.values.addValue(5.0, 1, 2);
		this.values.addValue(7.5, 2, 0);
		this.values.addValue(2.5, 2, 1);
		this.values.addValue(5.0, 2, 2);
		
		this.valuesMin = new DefaultKeyedValues2D();
		this.valuesMin.addValue(Double.MIN_VALUE, 0, 0);
		this.valuesMin.addValue(2.5, 0, 1);
		this.valuesMin.addValue(-2.5, 0, 2);
		
		this.valuesMax = new DefaultKeyedValues2D();
		this.valuesMax.addValue(Double.MAX_VALUE, 0, 0);
		this.valuesMax.addValue(2.5, 0, 1);
		this.valuesMax.addValue(-2.5, 0, 2);
		
		this.valuesSumZero = new DefaultKeyedValues2D();
		this.valuesSumZero.addValue(0.0, 0, 0);
		this.valuesSumZero.addValue(2.5, 0, 1);
		this.valuesSumZero.addValue(-2.5, 0, 2);
		
		this.valuesNull = new DefaultKeyedValues2D();
		this.valuesNull.addValue(null, 0, 0);
		this.valuesNull.addValue(null, 0, 1);
		this.valuesNull.addValue(2.5, 0, 2);
		
		
	}
	
	@Test
	public void calculateRowTotalTopRow() {
		double result = DataUtilities.calculateRowTotal(values, 0);
		System.out.println(result);
		assertEquals(15.0, result, .000000001d);	
		
	}
	@Test
	public void calculateRowTotalForMiddleRow() {
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals(15.0, result, .000000001d);
	}
	@Test
	public void calculateRowTotalBottomRow() {		
		double result = DataUtilities.calculateRowTotal(values, 2);
		assertEquals(15.0, result, .000000001d);
	}

	@Test
	public void calculateRowTotalWithMinValueAndFirstRow() {		
		double result = DataUtilities.calculateRowTotal(valuesMin, 0);
		this.values.clear();
		assertEquals(Double.MIN_VALUE, result, .000000001d);
	}

	@Test
	public void calculateRowTotalWithMaxValueAndFirstRow() {
		double result = DataUtilities.calculateRowTotal(valuesMax, 0);
		this.values.clear();
		assertEquals(Double.MAX_VALUE, result, .000000001d);
	}

	@Test
	public void calculateRowTotalWithSumOf0AndFirstRow() {
		double result = DataUtilities.calculateRowTotal(valuesSumZero, 0);
		assertEquals(0.0, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalWithNullValues() {
		double result = DataUtilities.calculateRowTotal(valuesNull, 0);
		assertEquals(2.5, result, .000000001d);
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
