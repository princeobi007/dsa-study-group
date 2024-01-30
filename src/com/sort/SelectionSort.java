package com.sort;

import java.util.Arrays;

public class SelectionSort {
    private static int[] selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++){
            int minIndex = i;
            for(int j= i+1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Array before sorting: " + Arrays.toString(arr));

        int [] sorted = selectionSort(arr);

        System.out.println("Array after sorting: " + Arrays.toString(sorted));
    }


















    /*
     public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the minimum element with the current element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
     */
}
