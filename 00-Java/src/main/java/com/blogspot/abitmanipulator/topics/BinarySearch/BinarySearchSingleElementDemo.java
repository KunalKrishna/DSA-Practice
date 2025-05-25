package com.blogspot.abitmanipulator.topics.BinarySearch;

import java.util.Arrays;

public class BinarySearchSingleElementDemo {
    public static void main(String[] args) {
        System.out.println("Binary Search : PoC!!!");
        //int[] arr = {1, 2, 3, 5, 7, 9, 10, 11, 12, 14, 16, 18, 19, 20}; // all unique elements
//        int[] arr = {1, 1, 1, 2, 4, 4, 4, 6, 8, 8, 8, 9}; // repeating elements (non-decreasing array)
        int[] arr = {2, 4, 5, 6, 6, 6, 6, 6}; // single element array
        System.out.println("arr = " + Arrays.toString(arr) + " n = "+ arr.length);
        System.out.println("********************************************");

        int max = arr[arr.length - 1] + 1;
        System.out.println("\nCASE : i < j");

//        trivialBinarySearchAttempt(arr, max);
//
//        leftBiasedBinarySearchAttempt(arr, max);
//        leftBiasedBinarySearch_Correct(arr, max);
//
//        rightBiasedBinarySearchAttempt(arr, max);
        rightBiasedBinarySearch_Correct(arr, max);
//
//        binarySearchRush_Attempt(arr, max);
    }

    // WRAPPER FUNCTIONS
    private static void trivialBinarySearchAttempt(int[] arr, int max) {
        System.out.println("\n________________________________");
        System.out.println("i < j | i = m, j = m | \t♾\uFE0FInfinite Loop♾\uFE0F");
        System.out.println("----------------------------------");
        boolean[] reached = new boolean[arr.length];
        for (int t = 0; t <= max; t++) {
            System.out.println("\n[key] = " + t);
            int i = binarySearch1a(arr, t, reached); // index returned by custom binary search
            printArr(arr);
            System.out.print("\n[key] = " + t + " found at index: " + i );
            verifyIndex(arr, t, i);  // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    private static void leftBiasedBinarySearchAttempt(int[] arr, int max) {
        System.out.println("\n________________________________");
        System.out.println("i < j | i = m+1, j = m | \tLeft-biased Lower-bound; needs post-check");
        System.out.println("----------------------------------");
        boolean[] reached = new boolean[arr.length];
        for (int t = 0; t <= max; t++) {
            System.out.println("\n[key] = " + t);
            int i = binarySearch1b(arr, t, reached);
            printArr(arr);
            System.out.print("\n[key] = "+t + " found at index: " + i );
            verifyIndex(arr, t, i); // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    private static void leftBiasedBinarySearch_Correct(int[] arr, int max) {
        System.out.println("\n________________________________");
        System.out.println("i < j | i = m+1, j = m  | \tLeft-biased Lower-bound; with POST-CHECK");
        System.out.println("----------------------------------");
        boolean[] reached = new boolean[arr.length];
        for (int t = 0; t <= max; t++) {
            System.out.println("\n[key] = "+t);
            int i = binarySearch1bPostProcessing(arr, t, reached);// returned by custom binary search
            printArr(arr);
            System.out.print("\n[key] = "+t + " found at index: " + i );
            verifyIndex(arr, t, i); // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    private static void rightBiasedBinarySearchAttempt(int[] arr, int max) {
        System.out.println("\n________________________________");
        System.out.println("i < j | i = m,  j = m-1 | \tInfinite loop ♾\uFE0F ❌");
        System.out.println("----------------------------------");
        boolean[] reached = new boolean[arr.length];
        for (int t = 0; t <= max; t++) {
            System.out.println("\n[key] = " + t);
            int i = binarySearch1c(arr, t, reached);
            printArr(arr);
            System.out.print("\n[key] = " + t + " found at index: " + i );
            verifyIndex(arr, t, i); // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    private static void rightBiasedBinarySearch_Correct(int[] arr, int max) {
        System.out.println("\n________________________________");
        System.out.println("i < j | i = m,  j = m-1 | \t Upper-bound (with mid-up rounding) Needs care ✅");
        System.out.println("----------------------------------");
        boolean[] reached = new boolean[arr.length];
        for (int t = 0; t <= max; t++) {
            System.out.println("\n[key] = "+t);
            int i = binarySearch1cRightBiased(arr, t, reached);
            printArr(arr);
            System.out.print("\n[key] = " + t + " found at index: " + i );
            verifyIndex(arr, t, i); // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    private static void binarySearchRush_Attempt(int[] arr, int max) {
        System.out.println("\n________________________________");
        System.out.println("i < j  i = m + 1, j = m - 1 | Skips target Over-narrowing❌");
        System.out.println("----------------------------------");
        boolean[] reached = new boolean[arr.length];
        for (int t = 0; t <= max; t++) {
            System.out.println("\n[key] = "+t);
            int i = binarySearch1d(arr, t, reached);
            printArr(arr);
            System.out.print("\n[key] = " + t + " found at index: " + i );
            verifyIndex(arr, t, i); // test
        }
        printReached(reached); //after finding every element every cell should be checked at least once.
    }

    // BINARY SEARCH VARIATIONS
    /**
     * i= m, j = m | i < j ❌ No progress	Infinite loop
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    private static int binarySearch1a(int[] arr, int t, boolean[] reached){
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(methodName + ": i = m, j = m | i < j");
        int l = 0,
                r = arr.length, // using [l, r)
                res = -1,
                counter = 0;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            counter++;
            reached[m] = true;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( arr[m] == t ) {
                return  m;
            } else if ( arr[m] < t ) {
                l = m;
            } else { // t < arr[m]
                r = m;
            }
            if(counter >= arr.length) { // binary search runs max (log n) iteration
                System.out.println("Entered ♾\uFE0FInfinite Loop♾\uFE0F");
                return res;
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
    private static int binarySearch1b(int[] arr, int t, boolean[] reached) {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(methodName + ": i = m + 1, j = m | i < j");
        int l = 0,
                r = arr.length, // using [l, r)
                res = -1;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            reached[m] = true;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( arr[m] == t ) {
                return m; // found
            } else if ( arr[m] < t ) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println("\t l = "+ l + " M = [] r = "+ r);
        return res; // error : not found
    }

    /**
     * i = m + 1, j = m | i < j ✅ Left-biased Lower-bound; needs post-check
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    private static int binarySearch1bPostProcessing(int[] arr, int t, boolean[]reached) {
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": i = m + 1, j = m | i < j");
        int l = 0,
                r = arr.length, // using [l, r)
                res = -1;
        int m = l + ( r - l ) / 2;
        while( l < r) {
            m = l + ( r - l ) / 2;
            System.out.println("\t l = "+ l + " [M = " + m + "] r = "+ r);
            reached[m] = true; //[1, 1, 1, 2, 4, 4, 4, 6, 8, 8, 8, 9 ] : for key = 1(4 or 8) only leftmost index reachability guaranteed !
            /*if (arr[m] == t ) {
                return m;
            } else */
            if ( arr[m] < t ) {
                l = m + 1;
            } else { // arr[m] >= t
                r = m;
            }
        }
        System.out.println("\t L = "+ l + " [M = ] R = "+ r);
        // post-processing
        if ( arr[m] == t ) { // l = r = m & A[m] = t
            reached[m] = true;
            System.out.println("First occurrence of "+ t +" at index: " + m);
            return m; // return l = r = m (any); // res = m
        }
        return res; //error
    }

    /**
     * i = m, j = m - 1 | i < j	✅ Upper-bound (with mid-up rounding) Needs care
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    private static int binarySearch1c(int[] arr, int t, boolean[]reached){
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": i = m, j = m - 1 | i < j");
        int l = 0, r = arr.length, res = -1, counter = 0;
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
    private static int binarySearch1cRightBiased(int[] arr, int t, boolean[]reached){
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": i = m, j = m - 1 | i < j");
        int l = 0,
                r = arr.length, // using [l, r)
                res = -1;
        while( l < r) {
//            int m =  ( l + r ) / 2; // results in infinite loop when l == m
//            int m =  ( l + r + 1 ) / 2; // Right-biased mid to avoid infinite loop when l == m (susceptible to int overflow)
            int m =  l + ( r - l ) / 2; // Right-biased mid to avoid infinite loop when l == m and avoid int overflow
            reached[m] = true;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( t < arr[m] ) {
                r = m; // move left including m
            } else { // t <= arr[m]
                l = m + 1;    // move right excluding m
            }
        }
        System.out.println("\t l = "+ l + " M = [] r = "+ r); // l = r
        int idx = l -1;
        if (idx >= 0 && arr[idx] == t) {
            reached[idx] = true;
            System.out.println("Last occurrence of "+ t +" at index: " + idx);
            return idx;
        }
        return  res; //error
    }

    /**
     * i = m + 1, j = m - 1 | i < j ❌ Skips target	Over-narrowing
     * @param arr non-decreasing array with "repetition allowed
     * @param t the key element
     * @return index if k exists in the arr, -1 otherwise
     */
    private static int binarySearch1d(int[] arr, int t, boolean[]reached){
        System.out.println("binarySearch1d: i = m + 1, j = m - 1 | i < j ");
        int l = 0, r = arr.length, res = -1;
        while( l < r) {
            int m = l + ( r - l ) / 2;
            reached[m] = true;
            System.out.println("\t l = "+ l + " M = " + m + " r = "+ r);
            if ( arr[m] == t ) {
                res = m;
                return  res;
            } else if (arr[m] < t ) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return  res;
    }

    // UTILITY FUNCTIONS
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

