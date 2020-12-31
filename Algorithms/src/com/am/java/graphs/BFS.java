package com.am.java.graphs;

import java.util.*;

public class BFS {

    private static ArrayList<Vertex> graph = new ArrayList<>();
    private static HashMap<Vertex, ArrayList<Vertex>> adj = new HashMap<>();
    static Vertex vertexOne = new Vertex(1, VertexState.UNVISITED, null, -1);
    static Vertex vertexTwo = new Vertex(2, VertexState.UNVISITED, null, -1);
    static Vertex vertexThree = new Vertex(3, VertexState.UNVISITED, null, -1);
    static Vertex vertexFour = new Vertex(4, VertexState.UNVISITED, null, -1);
    static Vertex vertexFive = new Vertex(5, VertexState.UNVISITED, null, -1);
    static Queue<Vertex> queue = new LinkedList<>();

    public static void main(String[] args){
        buildGraph();
        bfs(vertexOne);
    }

    private static void bfs(Vertex startVertex){
        startVertex.state = VertexState.VISITED_WITH_UNVISITED_NEIGHBOURS;
        startVertex.distance = 0;
        queue.add(vertexOne);
        while (!queue.isEmpty()){
            Vertex u = queue.remove();
            for (Vertex v: adj.get(u)){
                if (v.state == VertexState.UNVISITED){
                    v.state = VertexState.VISITED_WITH_UNVISITED_NEIGHBOURS;
                    v.parent = u;
                    v.distance = u.distance + 1;
                    queue.add(v);
                }
            }
            u.state = VertexState.VISTED_WITH_ALL_NEIGHBOURS_VISITED;
            System.out.println("distance from " + startVertex.id + " to " + u.id + " = " + u.distance);
        }
    }

    private static void buildGraph() {
        graph.add(vertexOne);
        graph.add(vertexTwo);
        graph.add(vertexThree);
        graph.add(vertexFour);
        graph.add(vertexFive);
        adj.put(vertexOne, new ArrayList<>(Arrays.asList(vertexTwo, vertexThree)));
        adj.put(vertexTwo, new ArrayList<>(Arrays.asList(vertexOne)));
        adj.put(vertexThree, new ArrayList<>(Arrays.asList(vertexOne, vertexFive)));
        adj.put(vertexFour, new ArrayList<>(Arrays.asList(vertexOne)));
        adj.put(vertexFive, new ArrayList<>(Arrays.asList(vertexThree, vertexFour)));
    }

}
