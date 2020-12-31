package com.am.java.graphs;

public class Vertex {

    int id;
    VertexState state;
    Vertex parent;
    int distance;

    public Vertex(int id, VertexState state, Vertex parent, int distance){
        this.id = id;
        this.state = state;
        this.parent = parent;
        this.distance = distance;
    }

}
