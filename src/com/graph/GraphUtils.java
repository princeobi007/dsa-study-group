package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphUtils {


    public static HashMap<String,List<String>> getGraph(){
        final var graphMap = new HashMap<String,List<String>>();
        graphMap.put("a",List.of("b","c"));
        graphMap.put("b",List.of("d"));
        graphMap.put("c",List.of("e"));
        graphMap.put("d",List.of("f"));
        graphMap.put("e",List.of());
        graphMap.put("f",List.of());

        return graphMap;
    }

    public static HashMap<String, List<String>> hasPathGraph(){
        final var graphMap = new HashMap<String,List<String>>();
        graphMap.put("f",List.of("g","i"));
        graphMap.put("g",List.of("h"));
        graphMap.put("h",List.of());
        graphMap.put("i",List.of("g","k"));
        graphMap.put("j",List.of());
        graphMap.put("k",List.of());
        return graphMap;
    }

    public static HashMap<String,List<String>> undirectedGraph(){
        final var graphMap = new HashMap<String,List<String>>();
        graphMap.put("i",List.of("j","k"));
        graphMap.put("j",List.of("i","k"));
        graphMap.put("k",List.of("i","m","l","j"));
        graphMap.put("m",List.of("k"));
        graphMap.put("l",List.of("k"));
        graphMap.put("o",List.of("n"));
        graphMap.put("n",List.of("o"));
        return graphMap;
    }

    public static HashMap<String, List<String>> convertEdgeToAdjacencyList(){
        final var edges = new String [][]{{"i","j"},{"k","i"},{"m","k"},{"k","l"},{"o","n"}};
        return edgesArrayToAdjacencyList(edges);
    }

    public static HashMap<String, List<String>> shortestPathGraph(){
        final var edges = new String [][]{{"w","x"},{"x","y"},{"z","y"},{"z","v"},{"w","v"}};
        return edgesArrayToAdjacencyList(edges);
    }

    public static HashMap<String, List<String>> edgesArrayToAdjacencyList(String [][] edges){
        final var graph = new HashMap<String, List<String>>();

        for(String [] pair: edges){
            String node1 = pair[0];
            String node2 = pair[1];

            graph.computeIfAbsent(node1, k->new ArrayList<>()).add(node2);
            graph.computeIfAbsent(node2, k->new ArrayList<>()).add(node1);
        }

        return graph;
    }

    public static HashMap<String, List<String>> connectedComponentCount(){
        final var graphMap = new HashMap<String, List<String>>();

        graphMap.put("0",List.of("8","1","5"));
        graphMap.put("1",List.of("0"));
        graphMap.put("5",List.of("0","8"));
        graphMap.put("8", List.of("0","5"));
        graphMap.put("2",List.of("3","4"));
        graphMap.put("3", List.of("2","4"));
        graphMap.put("4", List.of("3","2"));

        return graphMap;
    }

    public static String[][] grid(){
        final var grid = new String[][] {
                {"w","l","w","w","w"},
                {"w","l","w","w","w"},
                {"w","w","w","l","w"},
                {"w","w","l","l","w"},
                {"l","w","w","l","l"},
                {"l","l","w","w","w"}};
        return grid;
    }

    public static void main(String[] args) {

        final var adjacencyList = GraphUtils.convertEdgeToAdjacencyList();

        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            String node = entry.getKey();
            List<String> neighbors = entry.getValue();

            System.out.print(node + " -> ");
            for (String neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

