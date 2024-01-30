package com.dynamicprogramming;

import java.util.HashMap;

public class Tribonacci {

    public static void main(String[] args) {
        int number = 20;
        Tribonacci tribonacci = new Tribonacci();

        System.out.printf("Trib(%d) is %d %n",number,tribonacci.trib(number));
    }

    private int trib(int n){
        return trib(n, new HashMap<>());
    }
    private int trib(int n, HashMap<Integer, Integer> memo){
        if(n == 0 || n == 1){
            return 0;
        }

        if(n == 2){
            return 1;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int currentTrib = trib(n-1,memo) + trib(n-2, memo) + trib(n-3, memo);

        memo.put(n, currentTrib);

        return currentTrib;
    }
}
