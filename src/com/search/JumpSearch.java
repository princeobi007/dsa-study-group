package com.search;

public class JumpSearch {
    public static void main (String ...args){
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                34, 55, 89, 144, 233, 377, 610};
        int target = 55;

        // Find the index of 'x' using Jump Search
        int index = jumpSearch(arr, target);

        // Print the index where 'x' is located
        System.out.println("\nNumber " + target +
                " is at index " + index);
    }

    private static int jumpSearch(int[] arr, int target) {
        int arrayLength = arr.length;
        int step = (int) Math.floor(Math.sqrt(arr.length-1));
        int prev = 0;

        for(int minStep = Math.min(step, arrayLength)-1; arr[minStep] < target; minStep = Math.min(step, arrayLength)-1){
            prev = step;
            step += (int)Math.floor(Math.sqrt(arrayLength));
            if (prev >= arrayLength)
                return -1;
        }

        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < target)
        {
            prev++;

            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, arrayLength))
                return -1;
        }

        // If element is found
        if (arr[prev] == target)
            return prev;

        return -1;
    }
}
