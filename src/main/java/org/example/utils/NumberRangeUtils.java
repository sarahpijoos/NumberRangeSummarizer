package org.example.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class with utility methods for everything related to the NumberRange functionality.
 */
public class NumberRangeUtils {

    /**
     * Function to sort array of int numbers.
     * This does not copy the array, this will mutate the given array.
     *
     * @param sourceArray The array that will be sorted.
     */
    public static void sort(int[] sourceArray) {
        if(sourceArray.length < 2) {
            return;
        }

        int arrayLength = sourceArray.length;
        int midPoint = arrayLength / 2;
        int lengthOfRightArray = arrayLength - midPoint;

        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[lengthOfRightArray];

        System.arraycopy(sourceArray, 0, leftArray, 0, midPoint);
        System.arraycopy(sourceArray, midPoint, rightArray, 0, lengthOfRightArray);

        sort(leftArray);
        sort(rightArray);

        merge(sourceArray, leftArray, rightArray);
    }

    /**
     * Private method used to enable merge sort as part of our sort method.
     *
     * @param sourceArray - The array to modify.
     * @param leftArray - The first half of the source array.
     * @param rightArray - The second half of the source array.
     */
    private static void merge(int[] sourceArray, int[] leftArray, int[] rightArray) {
        int leftIndex = 0;
        int rightIndex = 0;
        int sourceIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if(leftArray[leftIndex] <= rightArray[rightIndex]) {
                sourceArray[sourceIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                sourceArray[sourceIndex] = rightArray[rightIndex];
                rightIndex++;
            }

            sourceIndex++;
        }

        while(leftIndex < leftArray.length) {
            sourceArray[sourceIndex] = leftArray[leftIndex];
            leftIndex++;
            sourceIndex++;
        }

        while(rightIndex < rightArray.length) {
            sourceArray[sourceIndex] = rightArray[rightIndex];
            rightIndex++;
            sourceIndex++;
        }
    }

    /**
     * Function used to format the numbers from a sorted array.
     * This will convert the numbers to a representation that indicates ranges where applicable.
     *
     * @param array - The array we want to create a string formatted representation of.
     * @return - The string formatted representation.
     */
    public static String formatRange(ArrayList<Integer> array) {
        List<String> result = new ArrayList<>();
        int start = array.getFirst();
        int end = array.getFirst();

        for (int number = 1; number < array.size(); number++) {
            if (start == array.get(number)) {
                continue;
            } else if (end + 1 == array.get(number)) {
                end++;
            } else if (start != end) {
                result.add(start + "-" + end);
                start = array.get(number);
                end = array.get(number);
            } else {
                result.add(String.valueOf(start));
                start = array.get(number);
                end = array.get(number);
            }
        }

        if (start != end) {
            result.add(start + "-" + end);
        } else {
            result.add(String.valueOf(start));
        }

        return String.join(", ", result);
    }
}
