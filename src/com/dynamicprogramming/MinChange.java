package com.dynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class MinChange {

    public static void main(String[] args) {
        MinChange minChange = new MinChange();
        int amount = 7;
        System.out.printf("Minimun coins for %d is %d",amount,minChange.minChange(amount,List.of(1,5,10 )));
    }

    private int minChange(int amount, List<Integer> coins){
        return minChange(amount,coins,new HashMap<>());
    }

    private int minChange(int amount, List<Integer> coins, HashMap<Integer,Integer> memo){
        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return -1;
        }

        if(memo.containsKey(amount)){
            return memo.get(amount);
        }

        int minCoins = -1;
        for(int coin : coins){
            int subAmount = amount - coin;

            int subCoins = minChange(subAmount,coins,memo);

            if(subCoins != -1){
                int numCoins = subCoins + 1;
                if(numCoins < minCoins || minCoins == -1){
                    minCoins =numCoins;
                }
            }
        }
        memo.put(amount,minCoins);
        return minCoins;
    }
}
