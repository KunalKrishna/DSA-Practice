package com.blogspot.abitmanipulator.DP;

import java.util.Arrays;

public class LPS {

    public static void main(String[] args) {
//        String str = "abcdb";
    String str = "accabbbcaacbcabcaccaabcbabaabbaaabaacbbaccaacccbcc";
        int n = str.length();
        int[][] dp = new int[n+1][n+1]; // since we need i+1 for i = n-1
        System.out.println(n);
        for(int i=n-1; i>=0; i--) {
            dp[i][i+1] = 1;
            for(int j=i+2; j<=n; j++) {
                char A_i = str.charAt(i);
                char A_j = str.charAt(j-1); //String is 0-indexed
//                System.out.println(A_i + " - "+ A_j );
                if (A_i == A_j) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
                }
//            System.out.println(Arrays.deepToString(dp));
            }
        }
        System.out.println("LSP = " + dp[0][n]);
//        return dp[0][n];
    }
}