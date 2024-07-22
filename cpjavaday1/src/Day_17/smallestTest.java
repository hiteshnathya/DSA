package Day_17;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class smallestTest{
    @Test
    public void testSmallest() {
        BiggestNumber bn = new BiggestNumber();
        int[] arr1 = {12, 45, 7, 23, 56, 89, 34};
        int[] arr2 = {-12, -45, -7, -23, -56, -89, -34};
        int[] arr3 = {0, 0, 0, 0, 0, 0, 0};
        int[] arr4 = {1};
        int[] arr5 = {};

        assertEquals(7, bn.smallest(arr1));
        assertEquals(-89, bn.smallest(arr2));
        assertEquals(0, bn.smallest(arr3));
        assertEquals(1, bn.smallest(arr4));

    }
}
