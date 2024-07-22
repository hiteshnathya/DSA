package Assignment.Day17.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathOperationsTest {
    private MathOperations mathOperations = new MathOperations();

    @Test
    void testAdd() {
        assertEquals(4, mathOperations.add(2, 2));
        assertEquals(-1, mathOperations.add(-2, 1));
        assertEquals(0, mathOperations.add(0, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(0, mathOperations.subtract(2, 2));
        assertEquals(-3, mathOperations.subtract(-2, 1));
        assertEquals(0, mathOperations.subtract(0, 0));
    }

    @Test
    void testMultiply() {
        assertEquals(4, mathOperations.multiply(2, 2));
        assertEquals(-2, mathOperations.multiply(-2, 1));
        assertEquals(0, mathOperations.multiply(0, 0));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, mathOperations.divide(4, 2), 0.01);
        assertEquals(-2.0, mathOperations.divide(-4, 2), 0.01);
        assertEquals(Double.POSITIVE_INFINITY, mathOperations.divide(4, 2), 0.01);
    }

    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> mathOperations.divide(4, 0));
        assertEquals("Cannot divide by zero!", exception.getMessage());
    }
}