package com.search;

import java.util.Arrays;

public class BinarySearch {

    public static void main (String ...args){
        int[] arr = {64, 25, 12, 22, 11};
        // find element 22
        int target = 22;
        System.out.println("unSorted Array position: "+Arrays.binarySearch(arr,target));


        // sort the array
        Arrays.sort(arr);
        System.out.println("Sorted Array position: "+Arrays.binarySearch(arr,target));
        int leftPointer = 0;
        int rightPointer = arr.length;
        final var position =getElementPositionBinarySearch(leftPointer,rightPointer,target,arr);
        System.out.println("getElementPositionBinarySearch recursive Position is "+position);

        while(leftPointer < rightPointer){
            int mid = Math.floorDiv(rightPointer+leftPointer, 2);

            if(arr[mid] == target){
                System.out.println("found target at position :"+ mid);
            }

            if(target > arr[mid]){
                leftPointer = mid;
            }else{
                rightPointer = mid;
            }

        }


    }

    static int getElementPositionBinarySearch(int leftPointer, int rightPointer, int target, int [] array){
        if(rightPointer >= leftPointer){

            int mid = Math.floorDiv(rightPointer+leftPointer, 2);
            if(array[mid] == target){
                return mid;
            }
            if(target > array[mid]){
                leftPointer = mid;
            }else{
                rightPointer = mid;
            }
            return getElementPositionBinarySearch(leftPointer,rightPointer,target,array);

        }
        return  -1;
    }
}
