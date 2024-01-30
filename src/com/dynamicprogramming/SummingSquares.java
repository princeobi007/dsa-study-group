package com.dynamicprogramming;

import java.util.HashMap;

public class SummingSquares  {

    private int summingSquares(int number) {
        return (int)summingSquares(number, new HashMap<>());
    }

    private double summingSquares(int number, HashMap<Integer,Double> memo) {
        if (number == 0) {
            return 0;
        }

        if(memo.containsKey(number)){
            return memo.get(number);
        }

        var minSquare = Double.POSITIVE_INFINITY;

        for (int i = 1; i <= Math.sqrt(number); i++) {
            final var square = i * i;
            final var numSquares = 1 + summingSquares(number - square,memo);

            if(numSquares < minSquare){
                minSquare = numSquares;
            }
        }
        final var result = minSquare;
        memo.put(number,result);
        return minSquare;
    }

}
