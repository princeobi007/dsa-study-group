package com.graph;

import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {
        ShortestPath shortestPath = new ShortestPath();
        System.out.printf("Shortest path is: %d %n",shortestPath.shortestPath("w","z",GraphUtils.shortestPathGraph()));
    }

    record PathDist(String node,int distance){}

    private int shortestPath(String startNode, String endNode, HashMap<String, List<String>> graph){
        Set<String> visited = new HashSet<>();

        Queue<PathDist> graphQueue = new LinkedList<>();

        graphQueue.add(new PathDist(startNode,0));
        visited.add(startNode);


        while (!graphQueue.isEmpty()){
            final var current = graphQueue.remove();

            visited.add(current.node);
            if(current.node.equalsIgnoreCase(endNode)){
                return current.distance;
            }
            final var graphNeighbours = graph.get(current.node);
            for(String node: graphNeighbours){
                if(!visited.contains(node)){
                    visited.add(node);
                    graphQueue.add(new PathDist(node,current.distance+1));
                }
            }
        }
        return 0;

    }
}
