package com.blogspot.abitmanipulator.comp550.graph;

import java.util.Arrays;

public class DFS {
    static int t = 1;
    static int back_edges = 0;
    public static void dfs(int[][] G, int u, int[] pre, int[] post ) {
        pre[u] = t++;
        for (int v : G[u])
            if (pre[v-1] == Integer.MAX_VALUE)
                dfs(G, v-1, pre, post );
        post[u]= t++;
    }

    public static void dfs_back_edge_counter(int[][] G, int u, int[] pre, int[] post , boolean[] visited) {
        visited[u] = true;
        for (int v : G[u])
            if (!visited[v - 1])
                dfs_back_edge_counter(G, v - 1, pre, post, visited);
            else if (pre[v - 1] < pre[u] && pre[u] < post[u] && post[u] < post[v - 1])
                back_edges++;
    }
    public static void main(String[] args) {
        // Q2.0
        // int[][] G = {{2, 4}, {},{1, 2 },{3} ,{}};
        // Q2.1 Q2.2
        //int[][]G = {{3}, {1}, {4}, {1, 2}};
        // Q2.3 Q2.4
        int[][]G = {{19, 20, 24}, {3, 9, 37}, {2, 9, 14}, {30}, {4, 16, 21, 29, 33}, {9, 13, 19, 24, 29, 39}, {18, 20, 32, 39}, {1, 2, 11, 17, 18, 19, 23, 33, 37}, {3, 26, 29, 34, 36, 38}, {1, 3, 15}, {12, 13, 31, 32}, {7, 11, 13, 20, 21, 28, 29}, {14, 27, 29}, {15, 20, 33}, {3, 27}, {15, 20, 29, 31}, {18, 37, 38}, {5, 10, 20, 36, 40}, {18, 21, 29}, {17, 23, 28}, {8, 12, 14, 15, 16, 18, 19, 25, 30, 34, 40}, {24, 27, 31, 35}, {17, 25, 33, 36}, {1, 2, 4, 5, 25, 35, 39}, {4, 10, 14, 15, 34, 39}, {4, 7, 14, 16, 17, 32}, {14, 39}, {19, 26}, {1, 27}, {7, 8, 17, 32, 33}, {4, 9, 22, 28, 30, 38}, {10, 23, 25, 30, 36, 37}, {2, 3, 9, 23, 26, 31}, {}, {6, 27, 37}, {1, 15, 18, 31, 32, 39}, {7, 10, 15, 19, 22, 27, 29, 31}, {5, 11, 27, 33}, {2, 8, 20, 24, 40}, {9, 11, 14, 16, 36}};

        int V = G.length;
        int[]  pre = new int[V]; Arrays.fill(pre, Integer.MAX_VALUE);
        int[] post = new int[V]; Arrays.fill(post, Integer.MAX_VALUE);

        for (int u = 0; u < V; u++)
            if(pre[u] == Integer.MAX_VALUE)
                dfs(G, u, pre, post );

        System.out.println(" pre[] : "+ Arrays.toString(pre));
        System.out.println("post[] : "+ Arrays.toString(post));

        // Q2.5
        boolean[] visited = new boolean[G.length];
        for (int u = 0; u < V; u++) {
            if(!visited[u]) {
                dfs_back_edge_counter(G, u, pre, post, visited );
            }
        }
        System.out.println("back_edges : "+ back_edges);
    }
}
