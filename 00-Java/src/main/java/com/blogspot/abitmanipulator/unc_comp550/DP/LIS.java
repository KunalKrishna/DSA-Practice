package com.blogspot.abitmanipulator.DP;

import java.util.Arrays;

public class LIS {

    public static void main(String[] args) {
//        int[] A = {6, 7, 8, 1, 2, 3};
        int[] A = {14, 84, 76, 26, 50, 45, 65, 79, 10, 3, 83, 43, 76, 1, 45, 72, 23, 94, 90, 4, 3, 54, 93, 38, 22, 42, 3, 22, 44, 50, 24, 23, 22, 46, 29, 3, 83, 56, 64, 19, 99, 86, 12, 33, 72, 71, 93, 42, 83, 67, 31, 59, 88, 84, 51, 59, 4, 25, 79, 42, 18, 55, 70, 67, 38, 44, 51, 78, 52, 39, 49, 3, 5, 70, 98, 59, 39, 17, 50, 98, 77, 54, 86, 23, 51, 95, 58, 46, 27, 55, 95, 1, 78, 82, 88, 74, 81, 52, 56, 43};
        int n = A.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int max = 1;
        int max_pos = -1;

        for(int i=1; i<n; i++) {
            for( int j=0; j<i; j++) {
                if(A[j] < A[i]) {
                    if(dp[i] < dp[j]+1) {
                        dp[i] = dp[j]+1 ;
                        parent[i] = j;
                    }
                }
                if(dp[i]>max) {
                    max = dp[i];
                    max_pos = i;
                }
            }
        }
        System.out.println(max_pos);
        System.out.println("     A[] = "+Arrays.toString(A));
        System.out.println("     d[] = "+Arrays.toString(dp));
        System.out.println("parent[] = "+Arrays.toString(parent));
        System.out.println("LIS = "+ max);

        while(max_pos != -1) {
            System.out.println(A[max_pos]);
            max_pos = parent[max_pos];
        }
    }

}
