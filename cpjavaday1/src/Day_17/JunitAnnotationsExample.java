package Day_17;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JunitAnnotationsExample {

    private ArrayList<String> list;

    // Executed once before all test cases
    @BeforeClass
    public static void m1() {
        System.out.println("Step 1: Using @BeforeClass, executed before all test cases");
        System.out.println("--------------------------------------------------------");
    }

    // Executed before each test case
    @Before
    public void m2() {
        list = new ArrayList<String>();
        System.out.println("Step 2: Using @Before annotations, executed before each test case");
        System.out.println("--------------------------------------------------------");
    }

    // Executed after each test case
    @After
    public void m4() {
        list.clear();
        System.out.println("Step 3: Using @After, executed after each test case");
        System.out.println("--------------------------------------------------------");
    }

    // Executed once after all test cases
    @AfterClass
    public static void m3() {
        System.out.println("Step 4: Using @AfterClass, executed after all test cases");
        System.out.println("--------------------------------------------------------");
    }

    @Test
    public void m5() {
        System.out.println("Executing test case m5...");
        list.add("test");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        System.out.println("m5 test case passed!");
    }

    @Ignore
    public void m6() {
        System.out.println("Using @Ignore, this execution is ignored");
    }

    @Test(timeout = 10)
    public void m7() {
        System.out.println("Executing test case m7...");
        System.out.println("Using @Test(timeout), it can be used to enforce timeout in JUnit4 test case");
        System.out.println("m7 test case passed!");
    }

    @Test
    public void m8() {
        System.out.println("Executing test case m8...");
        System.out.println("Using @Test(expected), it will check for specified exception during its execution");
        System.out.println("m8 test case passed!");
    }
}