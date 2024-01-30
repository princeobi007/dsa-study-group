package com.dynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class SumProblem {

    /**
     * The idea is to subtract values in the array from amount recursively till we get to 0.
     * If it is possible to subtract till 0, we know the values in the array can sum up to the problem.
     * We use memoization to store problems we have solved before, so we don't repeat sub problem.
     *
     */

    public static void main(String[] args) {
        SumProblem sumProblem = new SumProblem();

        System.out.printf("sum possible %s ", sumProblem.sumPossible(15, List.of(1, 10, 5, 3)));
    }

    private boolean sumPossible(int amount , List<Integer> numbers){
        return sumPossible(amount,numbers, new HashMap<>());
    }

    private boolean sumPossible(int amount , List<Integer> numbers, HashMap<Integer,Boolean> memo){
        //Base case 0: it's possible to sum elements in the array to get value
        if(amount == 0){
            return true;
        }

        //base case 1: it's not possible. we have subtracted and gotten a negative number
        if(amount < 0){
            return false;
        }

        //base case contains: we check to see if this problem has been solved before
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }

        //iterate through the numbers in the list
        for(int num : numbers){
            //foreach element we find subAmount by subtracting the element from amount
            int subAmount = amount - num;

            //foreach subAmount we solve recursively
            if(sumPossible(subAmount, numbers)){
                //If true save the answer for this occurrence
                memo.put(amount, true);
                return true;
            }
        }
        //if we iterate through all the elements and can't get 0 we save answer and return false
        memo.put(amount,false);
        return false;
    }
}
