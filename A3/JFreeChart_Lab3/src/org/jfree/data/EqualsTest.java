package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class EqualsTest {
    private Range testRange;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	testRange = new Range(-10, 10);
    }
    
    // Test case covering null comparison where r1 != null
    @Test
    public void testEqualsNull() {
        assertFalse(testRange.equals(null));
    }
    
    // Test case covering different range comparison where r1 != r2
    @Test
    public void testEqualsDifferentRanges() {
    	Range differentRange = new Range(-2, 7);
        assertFalse(testRange.equals(differentRange));
    }

    // Test case covering reflexive comparison where r == r
    @Test
    public void testEqualsReflexive() {
        assertTrue(testRange.equals(testRange));
    }
    
    // Test case covering symmetric comparison where r1 == r2
    @Test
    public void testEqualsSymmetric() {
    	Range testRange2 = new Range(-10, 10);
    	assertTrue(testRange.equals(testRange2) && testRange2.equals(testRange));
    }
    
    // Test case covering transitive comparison where r1 == r2 == r3
    @Test
    public void testEqualsTransitive() {
    	Range testRange2 = new Range(-10, 10);
    	Range testRange3 = new Range(-10, 10);
    	assertTrue(testRange.equals(testRange2) && testRange2.equals(testRange3) && testRange.equals(testRange3));
    }

    // Test case covering consistency of equals method where r1 == r2
    @Test
    public void testEqualsConsistency() {
    	Range testRange2 = new Range(-10, 10);
        assertTrue(testRange.equals(testRange2) == testRange2.equals(testRange));
    }
    
    // Test case covering equality when lower bounds are different but upper bounds are the same
    @Test
    public void testEqualsDifferentLowerBoundSameUpperBound() {
        Range differentLowerBound = new Range(-5, 10);
        assertFalse(testRange.equals(differentLowerBound));
    }
    
    // Test case covering equality when upper bounds are different but lower bounds are the same
    @Test
    public void testEqualsSameLowerBoundDifferentUpperBound() {
        Range differentUpperBound = new Range(-10, 5);
        assertFalse(testRange.equals(differentUpperBound));
    }
    
    // Test case covering equality when both lower and upper bounds are different
    @Test
    public void testEqualsDifferentBounds() {
        Range differentBounds = new Range(-5, 5);
        assertFalse(testRange.equals(differentBounds));
    }
    
    // Test case covering equality with an object of a different type
    @Test
    public void testEqualsWithDifferentType() {
        Object differentType = new Object();
        assertFalse(testRange.equals(differentType));
    }
    
    // Test case covering equality with the same instance
    @Test
    public void testEqualsSameInstance() {
        assertTrue(testRange.equals(testRange));
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
