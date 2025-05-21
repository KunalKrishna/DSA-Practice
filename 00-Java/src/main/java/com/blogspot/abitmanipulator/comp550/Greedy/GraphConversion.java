package com.blogspot.abitmanipulator.Greedy;

import java.util.*;

public class GraphConversion {
    public static int[][][] convertToAdjacencyList(int[][] graph) {
        int n = graph.length; // Number of nodes
        int[][][] G = new int[n][][]; // 1-indexed adjacency list

        for (int i = 0; i < n; i++) {
            List<int[]> edges = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (graph[i][j] > 0) { // If an edge exists
                    edges.add(new int[]{j + 1, graph[i][j]}); // Shift index by 1
                }
            }
            G[i] = edges.toArray(new int[0][]); // Convert List<int[]> to int[][]
        }
        return G;
    }

    public static void printGraph(int[][][] G) {
        for (int i = 0; i < G.length; i++) {
            System.out.print(i+1 + " -> ");
            for (int[] edge : G[i]) {
                System.out.print("{" + edge[0] + ", " + edge[1] + "} ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
            };
        System.out.println(Arrays.deepToString(graph));
        System.out.println();
        int[][][] G = convertToAdjacencyList(graph);
        System.out.println();
        //System.out.println(Arrays.deepToString(G));
        printGraph(G);
    }
}

