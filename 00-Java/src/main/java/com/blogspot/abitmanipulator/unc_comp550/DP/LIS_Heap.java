package com.blogspot.abitmanipulator.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS_Heap {
    public static int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int pos = Collections.binarySearch(sub, num);
            /*
            If key is not present, then it returns "(-(insertion point) - 1)".
            The insertion point is defined as the point at which the key would be inserted into the list.
            * */
            if (pos < 0) pos = -(pos + 1); // pos = insertion point
            if (pos == sub.size()) {
                sub.add(num);
                System.out.println("Appended : "+sub);
            }
            else{
                sub.set(pos, num);
                System.out.println("replaced at "+pos+" : "+sub);
            }
        }
        return sub.size();
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums)); // Output: 4 (LIS = {2, 3, 7, 101})
    }
}

