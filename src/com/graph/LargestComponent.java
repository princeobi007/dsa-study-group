package com.graph;

import java.util.*;

public class LargestComponent {

    public static void main(String[] args) {
        LargestComponent largestComponent = new LargestComponent();
        System.out.printf("Largest Component: %d %n",largestComponent.largestComponent(GraphUtils.connectedComponentCount()));
    }

    record ExploreMap(Boolean explored,int count){}

    private int largestComponent(HashMap<String, List<String>> graph){
        final var visitedNodes = new HashSet<String>();
        int maxComponents = Integer.MIN_VALUE;
        for(Map.Entry<String, List<String>> entry: graph.entrySet()){
            final var currentNode = entry.getKey();
            final var exploredSize = explore(currentNode,graph,visitedNodes);
            maxComponents = Math.max(maxComponents,exploredSize);

        }
        return maxComponents;
    }

    private int explore(String startNode, HashMap<String,List<String>> graph, Set<String> visited){
        if(visited.contains(startNode)){
            return 0;
        }

        int size = 1;
        visited.add(startNode);
        final var currentNeighbors = graph.get(startNode);

        for(String node: currentNeighbors){
           size += explore(node,graph,visited);

        }
        return size;
    }
}
