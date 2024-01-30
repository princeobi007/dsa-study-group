package com.dynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class CountPaths {

    private List<List<String>> grid = List.of(
            List.of("O", "O", "X", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
            List.of("O", "O", "X", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
            List.of("O", "O", "O", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
            List.of("X", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"),
            List.of("X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
            List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "X", "X", "O"),
            List.of("O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "X", "O"),
            List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O"),
            List.of("X", "X", "X", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O"),
            List.of("O", "O", "O", "O", "X", "X", "O", "O", "O", "O", "X", "O", "O", "O", "O"),
            List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
            List.of("O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
            List.of("O", "O", "O", "O", "X", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O"),
            List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O"),
            List.of("O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O")
    );


    public static void main(String[] args) {
        CountPaths countPaths = new CountPaths();
        System.out.printf("The number of paths through the grid is %d", countPaths.countPaths(countPaths.grid));
    }

    private int countPaths(List<List<String>> grid) {
        return countPaths(0, 0, grid, new HashMap<>());
    }

    private int countPaths(int row, int column, List<List<String>> grid, HashMap<List<Integer>, Integer> memo) {
        if (row == grid.size() || column == grid.get(0).size()) {
            return 0;
        }

        if (grid.get(row).get(column).equalsIgnoreCase("X")) {
            return 0;
        }

        if (row == grid.size() - 1 && column == grid.get(0).size() - 1) {
            return 1;
        }

        final var currentPos = List.of(row, column);

        if (memo.containsKey(currentPos)) {
            return memo.get(currentPos);
        }

        int currentPathCount = countPaths(row + 1, column, grid, memo) + countPaths(row, column + 1, grid, memo);
        memo.put(currentPos, currentPathCount);
        return currentPathCount;
    }
}
