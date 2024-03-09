package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateRowTotalTest {

	private Mockery mockingContext;
	private Values2D values;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// setup
		this.mockingContext = new Mockery();
		this.values = this.mockingContext.mock(Values2D.class);
	}

	// Tests the calculation of the row total for the top row, ensuring correct summation of values.
	@Test
	public void calculateRowTotalTopRow() {
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(4));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(5));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, 0);

		assertEquals(15.0, result, .000000001d);
	}

	// Tests the calculation of the row total for the bottom row, ensuring correct summation of values.
	@Test
	public void calculateRowTotalBottomRow() {
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(4));
				oneOf(values).getValue(2, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(2, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(2, 2);
				will(returnValue(5));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, 2);

		assertEquals(15.0, result, .000000001d);
	}

	// Tests the calculation of the row total for a middle row, ensuring correct summation of values.
	@Test
	public void calculateRowTotalForMiddleRow() {
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(4));
				oneOf(values).getValue(1, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(1, 2);
				will(returnValue(5));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, 1);

		assertEquals(15.0, result, .000000001d);
	}

	// Tests the calculation of the row total with minimum value in the first column, ensuring correct handling of edge case values.
	@Test
	public void calculateRowTotalWithMinValueAndFirstCol() {
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(4));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MIN_VALUE));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(-2.5));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, 0);

		assertEquals(Double.MIN_VALUE, result, .000000001d);
	}

	// Tests the calculation of the row total with maximum value in the first column, ensuring correct handling of edge case values.
	@Test
	public void calculateRowTotalWithMaxValueAndFirstCol() {
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(4));
				oneOf(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(-2.5));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, 0);

		assertEquals(Double.MAX_VALUE, result, .000000001d);
	}

	// Tests the calculation of the row total for a row with maximum integer value index, ensuring correct handling of large index values.
	@Test
	public void calculateRowTotalWithMaxValueRow() {
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(4));
				oneOf(values).getValue(Integer.MAX_VALUE, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(Integer.MAX_VALUE, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(Integer.MAX_VALUE, 2);
				will(returnValue(5.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, Integer.MAX_VALUE);

		assertEquals(15.0, result, .000000001d);
	}

	// Tests the calculation of the row total for a row with minimum integer value index, ensuring correct handling of large negative index values.
	@Test
	public void calculateRowTotalWithMinValueRow() {
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(4));
				oneOf(values).getValue(Integer.MIN_VALUE, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(Integer.MIN_VALUE, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(Integer.MIN_VALUE, 2);
				will(returnValue(5.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, Integer.MIN_VALUE);

		assertEquals(15.0, result, .000000001d);
	}

	// Tests the calculation of the row total with the sum of values equal to zero in the first row, ensuring correct handling of zero-sum scenarios.
	@Test
	public void calculateRowTotalWithSumOf0AndFirstRow() {
		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(4));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(-10));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, 0);

		assertEquals(0.0, result, .000000001d);
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
