package com.graph;

import java.util.HashSet;
import java.util.Set;

public class MinimumIsland {
    public static void main(String[] args) {
        final var grid = GraphUtils.grid();
        final Set<String> visited = new HashSet<>();
        int minimumIsland = Integer.MAX_VALUE;
        MinimumIsland minimumIslandObj = new MinimumIsland();

        for(int row = 0; row < grid.length;row++){
            for(int col = 0; col < grid[0].length; col++){
                final var currentIslandCount = minimumIslandObj.exploreIsland(grid,row,col,visited);
                if(currentIslandCount > 0){
                    minimumIsland = Math.min(minimumIsland,currentIslandCount);
                }
            }
        }
        System.out.printf("Minimum island count is %d",minimumIsland);
    }

    private int exploreIsland(String[][] grid, int row, int col, Set<String> visited) {
        /*Base Case 0: Check that row and col are inbound*/
        final var rowInbound = 0 <= row && row < grid.length;
        final var colInbound = 0 <= col && col < grid[0].length;

        if(!rowInbound || !colInbound){
            return 0;
        }

        /*Base case 1: check that current node is not water
         */

        if(grid[row][col].equalsIgnoreCase("w")){
            return 0;
        }

        final var currentPosition = row+","+col;

        //Base case 2: check that position has not been visited

        if(visited.contains(currentPosition)){
            return 0;
        }

        visited.add(currentPosition);
        int currentCount = 1;

        currentCount += exploreIsland(grid,row-1,col,visited);
        currentCount += exploreIsland(grid,row+1,col,visited);
        currentCount += exploreIsland(grid, row,col-1,visited);
        currentCount += exploreIsland(grid, row, col+1,visited);

        return currentCount;
    }
}
