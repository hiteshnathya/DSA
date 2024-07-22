package Day_17;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class productTest {

        @Test
        public void testProduct() {
        BiggestNumber bn = new BiggestNumber();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 5, 5};
        int[] arr3 = {-1, -2, -3};
        int[] arr4 = {0, 1, 2, 3};

        assertEquals(120, bn.product(arr1));
        assertEquals(125, bn.product(arr2));
        assertEquals(-6, bn.product(arr3));
        assertEquals(0, bn.product(arr4));

    }

    }

