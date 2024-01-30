package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();

        bfs.breadthFirstSearch(GraphUtils.getGraph(),"a");
    }


    private void breadthFirstSearch(HashMap<String, List<String>> graph, String startNode){


        Queue<String> graphQueue = new LinkedList<>();
        graphQueue.add(startNode);

        while(!graphQueue.isEmpty()){
            final var current = graphQueue.remove();
            System.out.println(current);

            final var graphNeighbors = graph.get(current);
            graphQueue.addAll(graphNeighbors);
        }
    }
}
