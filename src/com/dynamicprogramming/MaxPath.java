package com.dynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class MaxPath {

    private List<List<Integer>> grid = List.of(
            List.of(1, 1, 3, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1),
            List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(1, 2, 1, 1, 6, 1, 1, 5, 1, 1, 0, 0, 1),
            List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(1, 1, 1, 5, 1, 1, 1, 1, 0, 1, 1, 1, 1),
            List.of(2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(2, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 1),
            List.of(2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(1, 1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1),
            List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1),
            List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(1, 42, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1),
            List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
            List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));

    int currentMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        MaxPath maxPath = new MaxPath();
        System.out.printf("Current Max %d", maxPath.maxPath(maxPath.grid));
    }

    private int maxPath(List<List<Integer>> grid) {
        return maxPath(0, 0, grid, new HashMap<List<Integer>, Integer>()).intValue();
    }

    private Double maxPath(int row, int column, List<List<Integer>> grid, HashMap<List<Integer>, Integer> memo) {
        if (row == grid.size() || column == grid.get(0).size()) {
            return Double.NEGATIVE_INFINITY;
        }

        if (row == grid.size() - 1 && column == grid.get(0).size() - 1) {
            return grid.get(row).get(column).doubleValue();
        }

        final var currentPos = List.of(row, column);

        if (memo.containsKey(currentPos)) {
            return memo.get(currentPos).doubleValue();
        }

        int currentPathWeight = grid.get(row).get(column);

        final var currentPathMax = Math.max(maxPath(row + 1, column, grid, memo), maxPath(row, column + 1, grid, memo));

        final var result = currentPathWeight + currentPathMax;

        memo.put(currentPos, (int) result);

        return result;
    }
}
