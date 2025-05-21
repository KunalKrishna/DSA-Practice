package com.blogspot.abitmanipulator.Greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    static class Item implements Comparable<Item> {
        int val , wt;
        float worth;
        Item(int val, int wt, float worth) {this.val=val; this.wt=wt; this.worth = worth;}
        @Override
        public int compareTo(Item that) {
            return Double.compare(that.worth, this.worth); // Descending order
        }
        @Override
        public String toString() {
            return "\nItem{" +
                    "val=" + val +
                    ", wight=" + wt +
                    ", worth=" + worth +
                    '}';
        }
    }
    public static void main(String[] args) {
//        int[] v = {1, 4, 4};
//        int[] w = {2, 3, 4};
//        int   B = 8;

//        int[] v = {201, 95, 131, 190, 220, 105, 221, 144, 183, 240, 229, 225, 146, 217, 242, 193, 130, 124};
//        int[] w = {23, 10, 16, 51, 29, 18, 22, 14, 27, 13, 22, 94, 51, 12, 3, 10, 14, 5};
//        int   B = 33;

        int[] v = {64, 111, 58, 168, 98, 192, 142, 129, 214, 205, 240, 243, 127, 190, 150, 216, 221, 242, 242, 123, 215, 237, 113, 93, 202, 187, 71};
        int[] w = {1, 2, 2, 23, 10, 38, 16, 24, 8, 18, 31, 59, 14, 27, 46, 21, 64, 49, 35, 40, 37, 11, 3, 10, 14, 44, 5};
        int  B = 31;

        int   n = v.length;
        System.out.println(n);
        Item[] items = new Item[n];
        for (int i = 0; i<n; i++) {
            items[i] = new Item(v[i], w[i], (float) v[i] /w[i]);
        }
        Arrays.sort(items);
        System.out.println(Arrays.toString(items) + "\n");
        float optimalVal = 0;
        int wtPicked = 0, i=0;
        while( wtPicked + items[i].wt < B) {
            wtPicked += items[i].wt;
            optimalVal += (items[i].wt * items[i].worth);
            System.out.println("wt picked = "+ items[i].wt + " val gained = "+(items[i].wt * items[i].worth));
            i++;
        }
        if(wtPicked < B) {
            optimalVal += ( (B-wtPicked) * items[i].worth);
            System.out.println("wt picked = "+ (B-wtPicked)+ " val gained = "+(B-items[i].wt) * items[i].worth);
        }
        System.out.println(optimalVal);
    }
}
