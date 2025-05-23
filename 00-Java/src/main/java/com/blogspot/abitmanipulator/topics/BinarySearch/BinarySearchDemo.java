package com.blogspot.abitmanipulator.topics.BinarySearch;

import java.util.Arrays;

public class BinarySearchDemo {
    public static void main(String[] args) {
        System.out.println("Binary Search : PoC!!!");
        //int[] arr = {1, 2, 3, 5, 7, 9, 10, 11, 12, 14, 16, 18, 19, 20}; // all unique elements
        int[] arr = {1, 1, 1, 2, 4, 4, 4, 6, 8, 8, 8, 9}; // repeating elements (non-decreasing array)
//        int[] arr = {2}; // single element array
        System.out.println("arr = "+ Arrays.toString(arr));
        System.out.println("**********************");

        int max = arr[arr.length-1]+1;
        System.out.println("\nCASE : i < j");

        balancedBinarySearchAttempt(max, arr);

        leftBiasedBinarySearchAttempt(arr, max);

        leftBiasedBinarySearch(max, arr);

        rightBiasedBinarySearchAttempt(max, arr);

        rightBiasedBinarySearchF(max, arr);

        binarySearchRush(max, arr);
    }

    /* WRAPPER FUNCTIONS */

    private static void balancedBinarySearchAttempt(int max, int[] arr) {
        int t = 0;
        System.out.println("________________");
        System.out.println("i < j | i = m, j = m  \t♾\uFE0FInfinite Loop♾\uFE0F");
        boolean[] reached = new boolean[arr.length];
        for (t = 0; t <= max; t++) {
            System.out.println("\n[key] = " + t);
            int i = binarySearch1a(arr, t, reached); // returned by custom binary search
            printArr(arr);
            System.out.print("\n[key] = " + t + " found at index: " + i );
            verifyIndex(arr, t, i);  // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    private static void leftBiasedBinarySearchAttempt(int[] arr, int max) {
        int t = 0;
        System.out.println("\n________________");
        System.out.println("i < j | i = m+1, j = m\tLeft-biased Lower-bound; needs post-check");
        boolean[] reached = new boolean[arr.length];
        for (t = 0; t <= max; t++) {
            System.out.println("\n[key] = " + t);
            int i = binarySearch1b(arr, t, reached);
            printArr(arr);
            System.out.print("\n[key] = "+t + " found at index: " + i );
            verifyIndex(arr, t, i); // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    private static void leftBiasedBinarySearch(int max, int[] arr) {
        int t = 0;
        System.out.println("\n________________");
        System.out.println("i < j | i = m+1, j = m \tLeft-biased Lower-bound; with POST-CHECK");
        boolean[] reached = new boolean[arr.length];
        for (t = 0; t <= max; t++) {
            System.out.println("\n[key] = "+t);
            int i = binarySearch1bPostProcessing(arr, t, reached);// returned by custom binary search
            printArr(arr);
            System.out.print("\n[key] = "+t + " found at index: " + i );
            verifyIndex(arr, t, i); // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    private static void rightBiasedBinarySearchAttempt(int max, int[] arr) {
        int t = 0;
        System.out.println("\n________________");
        System.out.println("i < j | i = m,  j = m-1\tInfinite loop ♾\uFE0F ❌");
        boolean[] reached = new boolean[arr.length];
        for (t = 0; t <= max; t++) {
            System.out.println("\n[key] = " + t);
            int i = binarySearch1c(arr, t, reached);
            printArr(arr);
            System.out.print("\n[key] = " + t + " found at index: " + i );
            verifyIndex(arr, t, i); // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    private static void rightBiasedBinarySearchF(int max, int[] arr) {
        int t = 0;
        System.out.println("\n________________");
        System.out.println("i < j | i = m,  j = m-1\t Upper-bound (with mid-up rounding) Needs care ✅");
        boolean[] reached = new boolean[arr.length];
        for (t = 0; t <= max; t++) {
            System.out.println("\n[key] = "+t);
            int i = binarySearch1cRightBiased(arr, t, reached);
            printArr(arr);
            System.out.print("\n[key] = " + t + " found at index: " + i );
            verifyIndex(arr, t, i); // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    private static void binarySearchRush(int max, int[] arr) {
        int t = 0;
        System.out.println("\n________________");
        System.out.println("i < j  i = m + 1, j = m - 1  Skips target Over-narrowing❌");
        boolean[] reached = new boolean[arr.length];
        for (t = 0; t <= max; t++) {
            System.out.println("\n[key] = "+t);
            int i = binarySearch1d(arr, t, reached);
            printArr(arr);
            System.out.print("\n[key] = " + t + " found at index: " + i );
            verifyIndex(arr, t, i); // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    /* BINARY SEARCH VARIATIONS */

    /**
     * i= m, j = m | i < j ❌ No progress	Infinite loop
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    public static int binarySearch1a(int[] arr, int t, boolean[] reached){
        System.out.println("binarySearch1a: i= m, j = m | i < j");
        int l = 0, r = arr.length-1, res = -1, counter = 0;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            reached[m] = true;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( arr[m] == t ) {
                res = m;
                return  res;
            } else if (arr[m] < t ) {
                l = m; counter++;
            } else {
                r = m; counter++;
            }
            if(counter >= arr.length) {
                System.out.println("Entered ♾\uFE0FInfinite Loop♾\uFE0F");
                return res; // binary search runs max (log n) iteration
            }
        }
        return  res;
    }

    /**
     * i = m + 1, j = m | i < j ❌  Left-biased	Lower-bound; w/o post-check
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    public static int binarySearch1b(int[] arr, int t, boolean[] reached) {
        System.out.println("binarySearch1b: i = m + 1, j = m | i < j");
        int l = 0, r = arr.length-1, res = -1;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            reached[m] = true;
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
    public static int binarySearch1bPostProcessing(int[] arr, int t, boolean[]reached) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("Current method name: " + methodName);
        System.out.println("binarySearch1bPostProcessing: i = m + 1, j = m | i < j");
        int l = 0, r = arr.length-1, res = -1;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            System.out.println("\t l = "+ l + " [M = " + m + "] r = "+ r);
            reached[m] = true; //[1, 1, 1, 2, 4, 4, 4, 6, 8, 8, 8, 9 ] : for key = 1(4 or 8) only leftmost index reachability guaranteed !
            if ( arr[m] < t ) {
                l = m + 1;
            } else { //arr[m] >= t
                r = m;
            }
        }
        System.out.println("\t L = "+ l + " [M = ] R = "+ r);
        // post-processing
        if ( arr[l] == t ) { // l = r = m & A[m] = t
            reached[l] = true;
            System.out.println("First occurrence of "+ t +" at index: " + l);
            return l; // res = l;
        }
        return res; //error
    }

    /**
     * i = m, j = m - 1 | i < j	✅ Upper-bound (with mid-up rounding) Needs care
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    public static int binarySearch1c(int[] arr, int t, boolean[]reached){
        System.out.println("binarySearch1c: i = m, j = m - 1 | i < j");
        int l = 0, r = arr.length-1, res = -1, counter = 0;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            reached[m] = true;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( arr[m] == t ) {
                res = m;
                return  res;
            } else if (arr[m] < t ) {
                l = m;   counter++;
            } else {
                r = m-1; counter++;
            }
            if(counter >= arr.length) {
                System.out.println("Entered ♾\uFE0FInfinite Loop♾\uFE0F");
                return res; // binary search runs max (log n) iteration
            }
        }
        return  res;
    }

    /**
     * a specific binary search variant often used to find the upper bound
     * (i.e., the last occurrence of a target element or the first element greater than the target
     * i = m, j = m - 1 | i < j	✅ Upper-bound (with mid-up rounding) Needs care
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    public static int binarySearch1cRightBiased(int[] arr, int t, boolean[]reached){
        System.out.println("binarySearch1cRightBiased: i = m, j = m - 1 | i < j");
        int l = 0, r = arr.length-1, res = -1;
        while( l < r) {
            int m =  ( l + r + 1 ) / 2; // Right-biased mid to avoid infinite loop when l == m
            reached[m] = true;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( arr[m] <= t ) {
                l = m;     // move right including m
            } else {
                r = m - 1; // move left excluding m
            }
        }
        System.out.println("\t l = "+ l + " M = [] r = "+ r);
        // post-check (optional if A[i] could not be t)
        if (arr[l] == t) return l;
        return  res;
    }

    /**
     * i = m + 1, j = m - 1 | i < j ❌ Skips target	Over-narrowing
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    public static int binarySearch1d(int[] arr, int t, boolean[]reached){
        System.out.println("binarySearch1d: i = m + 1, j = m - 1 | i < j ");
        int l = 0, r = arr.length-1, res = -1;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            reached[m] = true;
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

    /* Utility functions     */
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
        System.out.print("]");
    }
    private static void verifyIndex(int[] arr, int t, int i) {
        int idx = Arrays.binarySearch(arr, t);
        //same sign; arr :[1, 2, 4, 4, 4, 6, 8] key=4 library binarySearch might return any valid index
        if((i == 0 && idx >= i) || (i == arr.length-1 && idx <= i) || (i * idx > 0) ) {
            System.out.print(" ✅ " + idx);
        } else {
            System.out.print(" ❌ " + idx);
        }
        System.out.println();
    }
    private static void printReached(boolean[] reached) {
        for(boolean is : reached) {
            if(!is)
                System.out.print("❌, ");
            else
                System.out.print("✅, ");
        }
        System.out.println();
    }
}

