package com.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TraversUnDirectedGraph {

    public static void main(String[] args) {
        TraversUnDirectedGraph traversUnDirectedGraph = new TraversUnDirectedGraph();
        final var startNode = "i";
        final var endNode = "m";
        final var hasPath =traversUnDirectedGraph.recursiveDepthFirstSearchHasPath(GraphUtils.undirectedGraph(),startNode,endNode, new HashSet<>());

        System.out.println("Is there a path between "+startNode+" and "+endNode+": "+hasPath);
        //["Modality in ('US')", "ImageType matches 'ORIGINAL.*'"]
    }


    private boolean recursiveDepthFirstSearchHasPath(HashMap<String, List<String>> graph, String source, String destination, Set<String> visitedNodes){
        if(visitedNodes.contains(source)){
            return false;
        }

        if(source.equalsIgnoreCase(destination)){
            return true;
        }


        visitedNodes.add(source);

        final var currentNeighbours = graph.get(source);

        for (String node : currentNeighbours) {
            if(recursiveDepthFirstSearchHasPath(graph, node,destination,visitedNodes)){
                return true;
            }
        }
        return false;
    }
}
