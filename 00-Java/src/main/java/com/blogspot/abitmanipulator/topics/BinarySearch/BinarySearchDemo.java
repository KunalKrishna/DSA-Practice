package com.blogspot.abitmanipulator.topics.BinarySearch;

import java.util.Arrays;

public class BinarySearchDemo {
    public static void main(String[] args) {
        System.out.println("Binary Search : PoC!!!");
        int[] arr = {1, 1, 1, 2, 4, 4, 4, 6, 8, 8, 8, 9};
        System.out.println("arr = "+ Arrays.toString(arr));
        System.out.println("**********************");

        int t = 0;
        int max = arr[arr.length-1]+1;

        System.out.println("\nCASE : i < j");
        System.out.println("________________");
        System.out.println("i < j | t = m, j = m  \tInfinite Loop ♾\uFE0F ❌ ");
//        for (t = 0; t <= max; t++) {
//            System.out.println("\n[key] = "+t);
//            int i = binarySearch1a(arr, t);
//            printArr(arr);
//            System.out.println(t + " found at index: " + i );
//
//            verifyIndex(arr, t, i);  // test
//        }

        System.out.println("\n________________");
        System.out.println("i < j | i = m+1, j = m\tLeft-biased Lower-bound; needs post-check");
        for (t = 0; t <= max; t++) {
            System.out.println("\n[key] = "+t);

            // returned by custom binary search
            int i = binarySearch1b(arr, t);
            printArr(arr);
            System.out.print(t + " found at index: " + i );

            verifyIndex(arr, t, i); // test
        }

        System.out.println("\n________________");
        System.out.println("i < j | i = m+1, j = m \tLeft-biased Lower-bound; with POST-CHECK");
        for (t = 0; t <= max; t++) {
            System.out.println("\n[key] = "+t);

            // returned by custom binary search
            int i = binarySearch1bPostProcessing(arr, t);
            printArr(arr);
            System.out.print(t + " found at index: " + i );

            verifyIndex(arr, t, i); // test
        }

        System.out.println("\n________________");
        System.out.println("i < j | i = m,  j = m-1\tInfinite loop ♾\uFE0F ❌");
//        for (t = 0; t <= max; t++) {
//            System.out.println("\n[key] = "+t);
//            int i = binarySearch1c(arr, t);
//            printArr(arr);
//            System.out.println(t + " found at index: " + i );
//
//            verifyIndex(arr, t, i); // test
//        }

        System.out.println("\n________________");
        System.out.println("i < j  i = m + 1, j = m - 1  Skips target Over-narrowing❌");
        for (t = 0; t <= 9; t++) {
            System.out.println("\n[key] = "+t);
            int i = binarySearch1d(arr, t);
            printArr(arr);
            System.out.print(t + " found at index: " + i );

            verifyIndex(arr, t, i); // test
        }

        System.out.println("\nCASE : i <= j");
        System.out.println("------------");
    }

    private static void verifyIndex(int[] arr, int t, int i) {
        int idx = Arrays.binarySearch(arr, t);
        //same sign; arr :[1, 2, 4, 4, 4, 6, 8] key=4 util might return any
        if((i == 0 && idx >= i) || (i == arr.length-1 && idx <= i) || (i * idx > 0) ) {
            System.out.print(" ✅");
        } else {
            System.out.print(" ❌ " + idx);
        }
        System.out.println();
    }

    /**
     * i= m, j = m | i < j ❌ No progress	Infinite loop
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    public static int binarySearch1a(int[] arr, int t){
        System.out.println("binarySearch1a: i= m, j = m | i < j");
        int l = 0, r = arr.length-1, res = -1;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( arr[m] == t ) {
                res = m;
                return  res;
            } else if (arr[m] < t ) {
                l = m;
            } else {
                r = m;
            }
        }
        printArr(arr);
        return  res;
    }

    /**
     * i = m + 1, j = m | i < j ❌  Left-biased	Lower-bound; w/o post-check
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    public static int binarySearch1b(int[] arr, int t) {
        System.out.println("binarySearch1b: i = m + 1, j = m | i < j");
        int l = 0, r = arr.length-1, res = -1;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( arr[m] == t ) {
                res = m;
                return res;
            } else if ( arr[m] < t ) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return res;
    }

    /**
     * i = m + 1, j = m | i < j ✅ Left-biased Lower-bound; needs post-check
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    public static int binarySearch1bPostProcessing(int[] arr, int t) {
        System.out.println("binarySearch1bPostProcessing: i = m + 1, j = m | i < j");
        int l = 0, r = arr.length-1, res = -1;
        int m = l + ( r - l ) / 2;
        System.out.println("\t l = "+ l + " [M = " + m + "] r = "+ r);
        while( l < r) {
            if ( arr[m] < t ) {
                l = m + 1;
                System.out.println("\t l = "+ l + " [M = " + m + "] r = "+ r);
            } else { //arr[m] >= t
                r = m;
                System.out.println("\t l = "+ l + " [M = " + m + "] r = "+ r);
            }
            m = l + ( r - l ) / 2;
        }
        // post-processing
        if ( arr[l] == t ) {
            res = l; //return l; System.out.println("First occurrence at index: " + l);
        }
        return res;
    }

    /**
     * i = m, j = m - 1 | i < j	✅ Upper-bound (with mid-up rounding) Needs care
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    public static int binarySearch1c(int[] arr, int t){
        System.out.println("binarySearch1c: i = m, j = m - 1 | i < j");
        int l = 0, r = arr.length-1, res = -1;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( arr[m] == t ) {
                res = m;
                return  res;
            } else if (arr[m] < t ) {
                l = m;
            } else {
                r = m-1;
            }
        }
        return  res;
    }

    /**
     * i = m + 1, j = m - 1 | i < j ❌ Skips target	Over-narrowing
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    public static int binarySearch1d(int[] arr, int t){
        System.out.println("binarySearch1d: i = m + 1, j = m - 1 | i < j ");
        int l = 0, r = arr.length-1, res = -1;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( arr[m] == t ) {
                res = m;
                return  res;
            } else if (arr[m] < t ) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return  res;
    }

    public static void printArr(int[] arr) {
        System.out.print("idx :[");
        for(int i=0; i<arr.length; i++) {
            System.out.print(i+ ", ");
        }
        System.out.print("]\n");
        System.out.print("arr :[");
        for (int j : arr) {
            System.out.print(j + ", ");
        }
        System.out.print("]\n");
    }
}

