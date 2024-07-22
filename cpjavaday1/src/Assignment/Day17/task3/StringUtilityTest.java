package Assignment.Day17.task3;

// StringUtilityTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringUtilityTest {
    @Test
    public void testReverseString() {
        System.out.println("Testing reverseString method...");
        assertEquals("olleh", StringUtility.reverseString("hello"));
        assertEquals(null, StringUtility.reverseString(null));
        assertEquals("", StringUtility.reverseString(""));
        System.out.println("reverseString method test passed!");
    }

    @Test
    public void testIsPalindrome() {
        System.out.println("Testing isPalindrome method...");
        assertTrue(StringUtility.isPalindrome("madam"));
        assertFalse(StringUtility.isPalindrome("hello"));
        assertFalse(StringUtility.isPalindrome(null));
        System.out.println("isPalindrome method test passed!");
    }

    @Test
    public void testConcatenateStrings() {
        System.out.println("Testing concatenateStrings method...");
        String[] strings = {"Hello", " ", "World"};
        assertEquals("Hello World", StringUtility.concatenateStrings(strings));
        assertEquals(null, StringUtility.concatenateStrings(null));
        assertEquals("", StringUtility.concatenateStrings(new String[0]));
        System.out.println("concatenateStrings method test passed!");
    }
}