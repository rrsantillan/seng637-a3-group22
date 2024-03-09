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
        
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
