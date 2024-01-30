package com.dynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class CountingChange {


    private int countingChange(int amount, List<Integer> coins){
        return countingChange(amount,0,coins, new HashMap<>());
    }

    private int countingChange(int amount,int coinIndex, List<Integer> coins, HashMap<List<Integer>,Integer> memo){
        if(amount == 0){
            return 1;
        }

        if(coinIndex >= coins.size()){
            return 0;
        }

        final var key = List.of(amount,coinIndex);

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int totalWays = 0;
        final var currentCoinValue = coins.get(coinIndex);

        for(int qty = 0; qty * currentCoinValue <= amount; qty++){
            final var subAmount = amount - (qty * currentCoinValue);
            totalWays += countingChange(subAmount, coinIndex +1,coins,memo);
        }

        memo.put(key,totalWays);
        return totalWays;
    }
}
