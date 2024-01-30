package com.graph;

import java.util.*;

public class DepthFirstSearch {

    public static void main(String[] args) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

        System.out.println("Iterative Depth first search");
        depthFirstSearch.iterativeDepthFirstSearch(GraphUtils.getGraph(), "a");
        System.out.println("=============================");

        System.out.println("Recursive depth first search");
        depthFirstSearch.recursiveDepthFirstSearch(GraphUtils.getGraph(), "a");
    }

    private void iterativeDepthFirstSearch(HashMap<String, List<String>> graph, String startNode) {
        Deque<String> graphStack = new ArrayDeque<>();
        graphStack.push(startNode);

        while (!graphStack.isEmpty()) {

            final var currentNode = graphStack.pop();
            System.out.println(currentNode);

            final var currentNodeNeighbors = graph.get(currentNode);


            for (String neighbor : currentNodeNeighbors) {
                graphStack.push(neighbor);
            }

        }
    }

    private void recursiveDepthFirstSearch(HashMap<String, List<String>> graph, String startNode) {
        System.out.println(startNode);

        final var currentNeighbours = graph.get(startNode);

        for (String node : currentNeighbours) {
            recursiveDepthFirstSearch(graph, node);
        }

    }
}
