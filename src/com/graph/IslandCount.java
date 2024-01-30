package com.graph;

import java.util.HashSet;
import java.util.Set;

public class IslandCount {

    public static void main(String[] args) {
        Set<String> visitedNodes = new HashSet<>();
        int count = 0;
        final var grid = GraphUtils.grid();
        IslandCount islandCount = new IslandCount();

        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length;column++){
                if(islandCount.exploreIslands(grid,row,column,visitedNodes)){
                    count += 1;
                }
            }
        }
        System.out.printf("Number of islands in grid id %d %n",count);
    }

    private boolean exploreIslands(String [][] grid, int row, int column, Set<String> visitedNodes){
        /*Base case 0: check that row and column are within the array boundary*/
        final var rowInbounds = 0 <= row && row < grid.length;
        final var colInbound = 0 <= column && column <grid[0].length;

        if(!rowInbounds || !colInbound){
            return false;
        }

        /*Base case 1: check that current node is not water*/
        if(grid[row][column].equalsIgnoreCase("w")){
            return false;
        }

        final var currentPos = row+","+column;

        /*Base case 2: check that we have not traversed this node*/
        if(visitedNodes.contains(currentPos)){
            return false;
        }

        visitedNodes.add(currentPos);
        exploreIslands(grid,row-1,column,visitedNodes);
        exploreIslands(grid,row+1,column,visitedNodes);
        exploreIslands(grid,row,column-1,visitedNodes);
        exploreIslands(grid,row,column+1,visitedNodes);

        return true;

    }
}
