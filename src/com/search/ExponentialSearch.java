package com.search;

import java.util.Arrays;

public class ExponentialSearch {

    // Driver code
    public static void main(String args[])
    {
        int arr[] = {2, 3, 4, 10, 40};
        int x = 10;
        int result = exponentialSearch(arr,
                arr.length, x);

        System.out.println((result < 0) ?
                "Element is not present in array" :
                "Element is present at index " +
                        result);
    }

    private static int exponentialSearch(int[] arr, int length, int x) {
        if(arr[0] == x){
            return 0;
        }
        // Find range for binary search by
        // repeated doubling
        int startIndex = 1;
        while (startIndex < length && arr[startIndex] <= x)
            startIndex = startIndex*2;

        return Arrays.binarySearch(arr,startIndex/2,Math.min(startIndex,length-1),x);
    }
}
