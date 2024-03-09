package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeContainsTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception { 
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-10, 10);
    }

    // A range of -10 to 10 should not contain -10.1
    @Test
    public void testBLBForContains() {
    	assertFalse(exampleRange.contains(-10.1));
    }
    
    // A range of -10 to 10 should contain -10"
    @Test
    public void testLBForContains() {
    	assertTrue(exampleRange.contains(-10));
    }

    // A range of -10 to 10 should contain -9.9 
    @Test
    public void testALBForContains() {
    	assertTrue(exampleRange.contains(-9.9));
    }
    
    // "A range of -10 to 10 should contain 0 
    @Test
    public void testNOMForContains() {
    	assertTrue(exampleRange.contains(0));
    }
    
    // "A range of -10 to 10 should contain 9.9", 
    @Test
    public void testBUBForContains() {
    	assertTrue(exampleRange.contains(9.9));
    }
    
    // "A range of -10 to 10 should contain 10"
    @Test
    public void testUBForContains() {
    	assertTrue( exampleRange.contains(10));
    }
    
    // "A range of -10 to 10 should not contain 10.1" 
    @Test
    public void testAUBForContains() {
    	assertFalse(exampleRange.contains(10.1));
    }
    
    @After
    public void tearDown() throws Exception { exampleRange = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}

