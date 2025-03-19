package com.blogspot.abitmanipulator.PSA_4;

import java.util.Arrays;

public class Q1 {
    /*
    * The input is an array A of n positive integers. We start at index 0 (i.e., one unit left of A), and in each step,
    * we are allowed to jump from index i to either i + 1 or i + 2. When we land on A[i], we pay a cost of A[i].
    * Our goal is to land on index n + 1 (i.e., one unit right of A) while minimizing the total cost. Describe an
    * O(n)-time algorithm that returns the minimum cost, explain why it’s correct, and analyze its running time.
    * Example: If A = [1, 10, 1], the algorithm should return 2
    * */
    public static void main(String[] args) {
        int[] A = {1, 10, 1};

        int res =  foo(A);
        System.out.println(res);

        int res2 =  foo2(A);
        System.out.println(res2);

    }

    public static int foo(int[] A) {
        int n = A.length;
        int[] dp = new int[n+2];
        // dp[i] : min (optimal) cost of landing i+1
        // return : dp[n+1]

        for(int i = 2; i<n+2; i++) {
            dp[i] = Math.min(dp[i-2], dp[i-1] )+ A[i-2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n+1];
    }

    public static int foo2(int[] A) {
        int n = A.length;
        int prev_prev = 0, prev = 0;

        for (int j : A) {
            int temp = prev;
            prev = Math.min(prev_prev, prev) + j;
            prev_prev = temp;
            System.out.println(prev_prev + "--" + prev);
        }
        return prev;
    }

}
