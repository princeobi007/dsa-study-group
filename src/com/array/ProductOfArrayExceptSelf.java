package com.array;


public class ProductOfArrayExceptSelf {

    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     */

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n]; // product before i from the the left to right
        int[] post = new int[n]; // product before i from the the right to left
        int[] result = new int[n]; // product before, multiply by product after => pre[i] * post[i];

        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            pre[i] = product;
            product = product * nums[i];
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            post[i] = product;
            product = product * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = pre[i] * post[i];
        }
        return result;

    }
}
