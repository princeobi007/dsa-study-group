package com.sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return; // Base case: the array is already sorted or empty
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Divide the array into two halves
        System.arraycopy(arr, 0, left, 0, left.length);
        System.arraycopy(arr, mid, right, 0, right.length);

        // Recursively sort the two halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves back together
        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0; // Index for the left subarray
        int j = 0; // Index for the right subarray
        int k = 0; // Index for the merged array

        // Compare elements from both subarrays and put them in the correct order
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from the left subarray, if any
        System.arraycopy(left, i, result, k, left.length - i);

        // Copy the remaining elements from the right subarray, if any
        System.arraycopy(right, j, result, k, right.length - j);
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Array before sorting: " + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("Array after sorting: " + Arrays.toString(arr));

        String text = "Array after sorting: ";

    }

 }


