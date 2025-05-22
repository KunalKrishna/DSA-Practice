package com.blogspot.abitmanipulator.Graph;

import java.util.ArrayList;
import java.util.List;

class Edge {
    int from;
    int to;
    int flow;
    int residualCapacity; // greater than > 0

    public Edge(int from, int to, int residualCapacity) {
        this.from = from;
        this.to = to;
        this.flow = 0;
        this.residualCapacity = residualCapacity;
    }

};

public class FordFulkerson {

    public int fordFulkerson(int[][] G, int s, int t) {
        int max_flow = 0;
        //build residual graph;

        // remaining algo


        return max_flow;
    }
    public static void main(String[] args) {
        // build graph
        int V = 5;
        List<Edge> G = new ArrayList<Edge>();

        // take s and t
        int s = 1, t = 5;

        //call function pass G, s, t & return answer
        FordFulkerson ff = new FordFulkerson();
        System.out.println("Maximum flow from "+s+" to "+t+" is "+  ff.fordFulkerson(G, s, t));
    }
}

