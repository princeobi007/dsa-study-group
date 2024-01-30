package com.search;

public class TernarySearch {

    // Driver code
    public static void main(String args[])
    {
        int leftPointer, rightPointer, position, key;

        // Get the array
        // Sort the array if not sorted
        int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Starting index
        leftPointer = 0;

        // end element index
        rightPointer = 9;

        // Checking for 5

        // Key to be searched in the array
        key = 5;

        // Search the key using ternarySearch
        position = ternarySearch(leftPointer, rightPointer, key, ar);

        // Print the result
        System.out.println("Index of " + key + " is " + position);

        // Checking for 50

        // Key to be searched in the array
        key = 50;

        // Search the key using ternarySearch
        position = ternarySearch(leftPointer, rightPointer, key, ar);

        // Print the result
        System.out.println("Index of " + key + " is " + position);
    }

    private static int ternarySearch(int leftPointer, int rightPointer, int key, int[] array) {
        /* mid formula
        mid1 = l + (r-l)/3
        mid2 = r – (r-l)/3
        If not, then we check whether the key is less than the element at mid1. If yes, then recur to the first part.
If not, then we check whether the key is greater than the element at mid2. If yes, then recur to the third part.
If not, then we recur to the second (middle) part.
         */
        if (rightPointer >= leftPointer) {
            int mid1 = leftPointer + (rightPointer - leftPointer) / 3;
            int mid2 = rightPointer - (rightPointer - leftPointer) / 3;

            if (key==array[mid1]) {
                return mid1;
            }
            if (key==array[mid2]) {
                return mid2;
            }

            if (key < array[mid1]) {
                //l, mid1 - 1, key, ar
                return ternarySearch(leftPointer, mid1 - 1, key, array); // take 1st part of array
            } else if (key > array[mid2]) {
                //mid2 + 1, r, key, ar
                return ternarySearch(mid2 + 1, rightPointer, key, array);// take 3rd part of array
            } else {
                //mid1 + 1, mid2 - 1, key, ar
                return ternarySearch(mid1 + 1, mid2 - 1, key, array);// take mid-section of array
            }
        }
        return -1;
    }
}
