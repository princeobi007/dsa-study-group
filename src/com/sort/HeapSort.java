package com.sort;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build the max heap
        buildMaxHeap(arr);

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the maximum element with the last element
            swap(arr, 0, i);

            // Reduce heap size and heapify the root
            maxHeapify(arr, i, 0);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;

        // Build the heap starting from the last non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    private static void maxHeapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // Find the largest element among the root and its children
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // If the largest element is not the root, swap them and recursively heapify the affected subtree
        if (largest != rootIndex) {
            swap(arr, rootIndex, largest);
            maxHeapify(arr, heapSize, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Array before sorting: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Array after sorting: " + Arrays.toString(arr));
    }
}

