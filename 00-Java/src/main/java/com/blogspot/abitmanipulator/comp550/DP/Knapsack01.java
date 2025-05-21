package com.blogspot.abitmanipulator.DP;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        //scenario 0
        int[] v0 = {3, 1, 5, 2};
        int[] w0 = {2, 1, 3, 4};
        int B0 = 4;
        int maxTheft0 = knapsack(v0, w0, B0);
        System.out.println(maxTheft0);

        //scenario 1
        int[] v = {3, 1, 2};
        int[] w = {2, 1, 4};
        int B = 4;

        //scenario 2
        int[] v1 = {3000, 2000, 1500};
        int[] w1 = {4, 3, 1};
        int B1 = 4;

        //scenario 3
        int[] v2 = {3, 17, 15, 5, 10, 9, 13, 15, 2, 1, 16, 9, 15, 1, 9, 14, 5, 18, 18, 1, 1, 11, 18, 8, 5, 9, 1, 5, 9, 10, 5, 5, 5, 9, 6, 1, 16, 11, 13, 4, 19, 17, 3, 7, 14, 14, 18, 9, 16, 13};
        int[] w2 = {6, 12, 17, 17, 10, 12, 1, 5, 16, 8, 4, 11, 14, 13, 8, 9, 10, 15, 10, 8, 10, 1, 1, 14, 19, 12, 8, 4, 10, 19, 15, 11, 17, 5, 10, 19, 11, 9, 6, 11, 19, 1, 15, 16, 17, 15, 16, 10, 11, 9};
        int B2 = 40;

        int maxTheft = knapsack(v, w, B);
        System.out.println(maxTheft);

        int maxTheft1 = knapsack(v1, w1, B1);
        System.out.println(maxTheft1);

        int maxTheft2 = knapsack(v2, w2, B2);
        System.out.println(maxTheft2);
    }

    public static int knapsack(int[] v, int[] w, int B) {
        int n = v.length;
        int[][] dp = new int[n+1][B+1];
        for( int i=1; i <= n; i++ ) { // 'i' denotes : if only first i items were available
            for( int b=1; b <= B; b++ ) { // 'b' denotes if max knapsack capacity were b
                if(w[i-1] > b) { // cannot consider taking this item OVERWEIGHT
                    dp[i][b] = dp[i-1][b]; // most steal till previous item
                } else { // consider talking this item
                    dp[i][b] = Math.max(dp[i-1][b], v[i-1] + dp[i-1][b-w[i-1]]);
                }
//                dp[i][b] = Math.max(dp[i-1][b], v[i-1] + dp[i-1][b-w[i-1]]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][B];
    }
}
