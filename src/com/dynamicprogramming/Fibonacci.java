package com.dynamicprogramming;

import java.util.HashMap;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int number = 8;
        int fib = fibonacci.fib(number);
        System.out.printf("Fib(%d) is %d %n",number,fib);
    }

    private int fib(int n){
        return fib(n, new HashMap<>());
    }

    private int fib(int n, HashMap<Integer, Integer> memo){
        //Base case 0: if at the bottom of the tree. return n
        if(n == 0 || n == 1){
            return n;
        }

        //Base case 1: if sequence has been solved before, return from previously saved response
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        //Evaluate current fib
        int currentFib = fib(n-1,memo)+fib(n-2,memo);

        //Store result from current evaluation
        memo.put(n, currentFib);

        //return result
        return currentFib;
    }
}
