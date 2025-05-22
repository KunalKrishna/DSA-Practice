package com.blogspot.abitmanipulator.array;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] arr = {7,8,1,5,10,2,4,3,6};

        //binary search only works correctly only on sorted arrays.
        Arrays.sort(arr);
        System.out.println("Input array in sorted order: "+Arrays.toString(arr));

        for (int key = 0; key < 11; key++) {
            System.out.println(key+" found at index = "+ SearchUtil.binarySearch(arr, key));
            System.out.println(key+" found at index = "+ SearchUtil.binarySearch2(arr, key));
            System.out.println();
        }
        return;
    }
}