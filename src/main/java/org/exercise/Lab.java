package org.exercise;

import java.util.*;

public class Lab {
    public static void main(String[] args) {
        //Nothing in the main method will be tested
        mergeSortedArrays(new int[]{1, 3, 6, 8, 0, 0, 0, 0}, new int[] {2, 9, 4, 5});
    }

    /**
     * Question 1: Find the smallest and largest numbers in an array
     * <p>
     * You are given an array of integers, with at least two values.
     * Find the smallest and largest numbers in the array, and pass them back in an array containing two values,
     * the largest and smallest.
     * <p>
     * You MAY ONLY use arrays, not other collections types (ie Lists).
     * <p>
     * YOU CAN'T USE A SORTING METHOD BUILT INTO JAVA
     *
     * @param array An array of integers with at least two values
     * @return An array of integers with two elements, the largest and smallest from the method parameter
     */
    public static int[] findLargestAndSmallest(int[] array) {
        int smallest = (int) Double.POSITIVE_INFINITY;
        int largest = (int) Double.NEGATIVE_INFINITY;
        for (int num : array) {
            if (num < smallest) {
                smallest = num;
            }
            if (num > largest) {
                largest = num;
            }
        }
        return new int[] {smallest, largest};
    }


    /**
     * Question 2: Remove duplicates from an array
     * <p>
     * You are given an array of ints that might have duplicates. You must remove any duplicates from the array,
     * and return an array that doesn't contain duplicates. The order of the elements in the original array
     * does not need to be kept the same.
     * <p>
     * You MAY use any collections types you wish, but the method must return an array.
     * <p>
     * Example: [1,4,3,2,1] would return, in any order, [1,2,3,4]
     *
     * @param array An array of ints that may or may not include duplicates
     * @return An array of ints that doesn't contain duplicates.
     */
    public static Object[] removeDuplicatesFromArray(int[] array) {
        ArrayList<Integer> nonDuplicates = new ArrayList<Integer>();
        for (int num : array) {
            if (!nonDuplicates.contains(num)) {
                nonDuplicates.add(num);
            }
        }
        return nonDuplicates.toArray();
    }

    /**
     * Given an array of integers, return the sum of the two largest values.
     * <p>
     * If the array is empty, return 0.
     * If the array has one value, return that value.
     * <p>
     * YOU CAN'T USE A SORTING METHOD BUILT INTO JAVA
     *
     * @param array An array of integers of any size.
     * @return Sum of the two largest values
     */
    public static int sumOfTwoLargest(int[] array) {
        int largestSum = (int) Double.NEGATIVE_INFINITY;
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    int sum = array[i] + array[j];
                    if (sum > largestSum) {
                        largestSum = sum;
                    }
                }
            }
        }
        return largestSum;
    }


    //BONUS QUESTION IS BELOW

    /**
     * BONUS:
     * <p>
     * Given two sorted arrays of integers, return a sorted array of the two original arrays merged together.
     * All valid numbers in these arrays are greater than 0.
     * <p>
     * array1 has enough empty space (represented by the value 0) to hold all valid values from the original two arrays
     * combined. The returned array must be array1 with the new values merged in.
     * <p>
     * For example:
     * array1 = [1,4,7,9,0,0,0]
     * array2 = [1,5,11]
     * returned array = [1,1,4,5,7,9,11]
     * <p>
     * No test cases are provided for this method, you will need to test it on your own.
     *
     * @param array1 Array of sorted integers
     * @param array2 Array of sorted integers
     * @return Array of sorted integers, merged from array1 and array2
     */
    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        for (int a2Idx = 0; a2Idx < array2.length; a2Idx++) {
            int insertIndex = findInsertIndex(array1, array2[a2Idx]);
            array1 = repairArray(array1, insertIndex, array2[a2Idx]);
        }
        System.out.println(Arrays.toString(array1));
        return array1;
    }

    public static int findInsertIndex(int[] searchArray, int value) {
        int searchIdx = 0;
        for (int i = 0; i < searchArray.length; i++) {
            if (searchArray[searchIdx] == 0) {
                break;
            } else if (value > searchArray[searchIdx]) {
                searchIdx++;
            }
        }
        return searchIdx;
    }

    public static int[] repairArray(int[] array, int idxToInsert, int valToInsert) {
        for (int i = array.length - 1; i > idxToInsert; i--) {
            array[i] = array[i - 1];
        }
        array[idxToInsert] = valToInsert;
        return array;
    }
}
