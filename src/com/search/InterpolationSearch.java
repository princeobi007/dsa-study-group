package com.search;

import java.util.Arrays;

public class InterpolationSearch {

    // Driver Code
    public static void main(String[] args)
    {

        // Array of items on which search will
        // be conducted.
        int arr[] = { 10, 12, 13, 16, 18, 19, 20, 21,
                22, 23, 24, 33, 35, 42, 47 };

        int n = arr.length;

        // Element to be searched
        int x = 18;
        int index = interpolationSearch(arr, 0, n - 1, x);

        // If element was found
        if (index != -1)
            System.out.println("Element found at index "
                    + index);
        else
            System.out.println("Element not found.");
    }

    private static int interpolationSearch(int[] arr, int startIndex, int endIndex, int target) {
        /*
        Given array arr, int target, int startingIndex, int endIndex
        Formula : pos = endIndex
                    + (((endIndex - startIndex) / (arr[endIndex] - arr[startIndex]))
                    * (target - arr[startIndex]));
         */

        int pos;

        // Since array is sorted, an element
        // present in array must be in range
        // defined by corner
        if (startIndex <= endIndex && target >= arr[startIndex] && target <= arr[endIndex]) {

            pos = endIndex
                    + (((endIndex - startIndex) / (arr[endIndex] - arr[startIndex]))
                    * (target - arr[startIndex]));

            // Condition of target found
            if (arr[pos] == target)
                return pos;

            // If x is larger, x is in right sub array
            if (arr[pos] < target)
                return interpolationSearch(arr, pos + 1, endIndex,
                        target);

            // If x is smaller, x is in left sub array
            if (arr[pos] > target)
                return interpolationSearch(arr, startIndex, pos - 1,
                        target);
        }
        return -1;

    }
}
