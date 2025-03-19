package com.blogspot.abitmanipulator.array;

import java.util.Arrays;

public class SearchUtil {

    public static int binarySearch(int[] arr, int key) {

        int index = -1;
        int l= 0, r= arr.length-1, mid;
        while(l<=r) {
            mid = (l+r)/2;
            System.out.println("mid = "+mid);

            if (key == arr[mid] ) {
                return mid; // found
            }
            if (key >= arr[mid]) {
                l = mid+1; // search in right partition
            } else {
                r = mid-1; // search in left partition
            }
        }
        return index; // key not found
    }

    public static int binarySearch2(int[] arr, int key) {

        int index = -1;
        int l= 0, r= arr.length-1, mid;
        while (l<=r) {
            mid = l+(r-l)/2;
            System.out.println("*mid = "+mid);
            if (key == arr[mid] ) {
                return mid; // found
            }
            if (key >= arr[mid]) {
                l = mid+1; // search in right partition
            } else {
                r = mid-1; // search in left partition
            }
        }
        return index; // key not found
    }

}
