package com.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HasPathGraphProblem {

    public static void main(String[] args) {
        HasPathGraphProblem hasPathGraphProblem = new HasPathGraphProblem();
        String source = "f";
        String destination = "k";

        System.out.println("Does path exist between "+source+" and "+destination+" (BFS) : "+hasPathGraphProblem.breadthFirstSearchHasPath(GraphUtils.hasPathGraph(),source,destination));

        System.out.println("Does path exist between "+source+" and "+destination+" (RDFS) : "+hasPathGraphProblem.recursiveDepthFirstSearchHasPath(GraphUtils.hasPathGraph(),source,destination));
    }


    private boolean breadthFirstSearchHasPath(HashMap<String, List<String>> graph, String source, String destination){
        Queue<String> pathGraph = new LinkedList<>();
        pathGraph.add(source);

        while (pathGraph.iterator().hasNext()){
            final var current = pathGraph.remove();
            System.out.println(current);

            if(current.equalsIgnoreCase(destination)){
                return true;
            }

            final var neighbors = graph.get(current);
            pathGraph.addAll(neighbors);
        }
        return false;
    }

    private boolean recursiveDepthFirstSearchHasPath(HashMap<String,List<String>> graph, String source, String destination){
        if(source.equalsIgnoreCase(destination)){
            return true;
        }
        System.out.println(source);



        final var currentNeighbours = graph.get(source);

        for (String node : currentNeighbours) {
            if(recursiveDepthFirstSearchHasPath(graph, node,destination)){
                return true;
            }
        }
        return false;
    }
}
