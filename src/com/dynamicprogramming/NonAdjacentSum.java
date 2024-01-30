package com.dynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class NonAdjacentSum {

    private int nonAdjacentSum(List<Integer> nums){
        return nonAdjacentSum(nums, 0, new HashMap<>());
    }

    private int nonAdjacentSum(List<Integer> nums, Integer index, HashMap<Integer,Integer> memo){
        if(index >= nums.size()){
            return 0;
        }

        if(memo.containsKey(index)){
            return memo.get(index);
        }

        final var currentMax =  Math.max(nonAdjacentSum(nums,index+2, memo), nonAdjacentSum(nums,index+1, memo));
        memo.put(index,currentMax);
        return currentMax;
    }
}
