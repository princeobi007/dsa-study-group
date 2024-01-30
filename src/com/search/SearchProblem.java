package com.search;

import java.util.Arrays;

public class SearchProblem {


        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int currentN = n-1;
            for(int counter = m; counter < nums1.length; counter++){
                 nums1[counter] = nums2[currentN];
                 currentN--;

            }
            selectionSort(nums1);
            System.out.println(nums1);
            // merge the first m and nums2

            //give nums1
            //given m
            //given nums2
            // nums1.length - m = n


        }

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

        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        int m = 3;
        int n = 3;

        merge(nums1,m, nums2, n);

        System.out.println("sorted array :"+nums1);

    }


}
