package org.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LabTest {
    @Test
    void findLargestAndSmallest() {
        Assertions.assertArrayEquals(new int[]{1, 7}, Lab.findLargestAndSmallest(new int[]{1, 5, 7, 2, 3}));
        Assertions.assertArrayEquals(new int[]{3, 3}, Lab.findLargestAndSmallest(new int[]{3, 3}));
        Assertions.assertArrayEquals(new int[]{1, 5}, Lab.findLargestAndSmallest(new int[]{1, 2, 3, 4, 5}));
        Assertions.assertArrayEquals(new int[]{7, 7}, Lab.findLargestAndSmallest(new int[]{7, 7, 7, 7, 7, 7}));
        Assertions.assertArrayEquals(new int[]{3, 5}, Lab.findLargestAndSmallest(new int[]{5, 4, 3}));
        Assertions.assertArrayEquals(new int[]{-5, 5}, Lab.findLargestAndSmallest(new int[]{5, 4, -5, 3}));
    }

    @Test
    void removeDuplicatesFromArray() {
        Object[] arr1 = Lab.removeDuplicatesFromArray(new int[]{1, 4, 3, 2, 1});
        Arrays.sort(arr1);
        Assertions.assertArrayEquals(new Object[]{1, 2, 3, 4}, arr1);

        Object[] arr2 = Lab.removeDuplicatesFromArray(new int[]{4, 3, 2, 1});
        Arrays.sort(arr2);
        Assertions.assertArrayEquals(new Object[]{1, 2, 3, 4}, arr2);

        Object[] arr3 = Lab.removeDuplicatesFromArray(new int[]{1, 1, 1, 1});
        Arrays.sort(arr3);
        Assertions.assertArrayEquals(new Object[]{1}, arr3);
    }

    @Test
    void sumOfTwoLargest() {
        Assertions.assertEquals(0, Lab.sumOfTwoLargest(new int[]{}));
        Assertions.assertEquals(5, Lab.sumOfTwoLargest(new int[]{5}));
        Assertions.assertEquals(9, Lab.sumOfTwoLargest(new int[]{5, 4}));
        Assertions.assertEquals(15, Lab.sumOfTwoLargest(new int[]{1, 7, 5, 2, -1, 8}));
        Assertions.assertEquals(-2, Lab.sumOfTwoLargest(new int[]{-1, -7, -5, -2, -1, -8}));
    }
}

