package com.graph;

import java.util.*;

public class ConnectedComponentsCount {

    public static void main(String[] args) {
        ConnectedComponentsCount connectedComponentsCount = new ConnectedComponentsCount();
        System.out.printf("Total connected components is: %d%n",connectedComponentsCount.countConnectedNode(GraphUtils.connectedComponentCount()));
    }

    private int countConnectedNode(HashMap<String, List<String>> graph){
        final var visitedNodes = new HashSet<String>();
        int connectedComponentCount = 0;
        for(Map.Entry<String,List<String>> entry: graph.entrySet()){
            final var currentNode = entry.getKey();
            if(explore(currentNode,graph,visitedNodes)){
                connectedComponentCount++;
            }


        }
        return connectedComponentCount;
    }

    private boolean explore(String startNode, HashMap<String,List<String>> graph, Set<String> visitedNodes){
        if(visitedNodes.contains(startNode)){
            return false;
        }

        visitedNodes.add(startNode);
        final var currentNeighbours = graph.get(startNode);

        for (String node : currentNeighbours) {
            explore( node,graph,visitedNodes);
        }
        return true;
    }
}
