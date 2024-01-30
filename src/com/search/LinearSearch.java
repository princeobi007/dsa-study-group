package com.search;

public class LinearSearch {


    public static void main(String ...args){
        int[] arr = {64, 25, 12, 22, 11};
        // find element 22
        int target = 22;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                System.out.println("found target at position : "+i);
            }
        }
    }
}
