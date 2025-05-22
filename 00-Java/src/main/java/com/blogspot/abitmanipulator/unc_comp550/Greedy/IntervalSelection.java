package com.blogspot.abitmanipulator.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalSelection {
    static class Interval implements Comparable<Interval> {
        int start, end;
        Interval(int s, int t) {start =s; end =t;}
        @Override
        public int compareTo(Interval that) {
            return this.end-that.end;
        }
        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) {
        //int[][] A = {{3, 5},{1, 2}, {2, 4}};
        int[][] A = {{4, 36}, {17, 147}, {5, 18}, {62, 67}, {16, 32}, {96, 128}, {21, 117}, {19, 122}, {64, 168}, {45, 99}, {12, 55}, {20, 26}, {79, 126}, {3, 9}, {89, 101}, {55, 112}, {26, 157}, {1, 2}, {16, 116}, {49, 70}, {26, 60}, {52, 153}, {16, 28}, {20, 83}, {158, 166}, {3, 7}, {7, 8}, {61, 140}, {1, 4}, {12, 170}, {19, 57}, {35, 110}, {54, 155}, {93, 137}, {47, 58}, {49, 114}, {115, 174}, {60, 61}, {64, 90}, {3, 142}, {4, 145}, {89, 119}, {24, 76}, {22, 154}, {63, 108}, {8, 27}, {26, 49}, {18, 77}, {106, 175}, {2, 87}, {7, 148}, {65, 66}, {36, 135}, {17, 118}, {96, 130}, {38, 171}, {4, 40}, {24, 38}, {22, 132}, {129, 144}};
        Interval[] A_interval = new Interval[A.length];
        int i=0;
        for(int[] each : A) {
            A_interval[i++] = new Interval(each[0],each[1]);
        }
        Arrays.sort(A_interval);
        System.out.println(Arrays.toString(A_interval));
        System.out.println("-------------------------------");
        List<Interval> S = new ArrayList<>();

        int j=0;
        for( i=0; i<A.length; i++) {
            if(i==0) {
                S.add(A_interval[i]);
                System.out.println("adding : "+(j+1)+" "+S.getLast());
                j++;
                continue;
            }
//            System.out.println();
            Interval prevInterval = S.getLast();
            int prev_start = prevInterval.start;
            int prev_end = prevInterval.end;
//            System.out.println("prev = " + prevInterval);

            Interval curr = A_interval[i];
            int start = curr.start;
            int   end = curr.end;
//            System.out.println("curr = " + curr);
//            System.out.println();
            if(prev_end < start) {
                S.add(curr);
                System.out.println("adding : "+(j+1)+" "+curr);
                j++;
            } else {
//                System.out.println("rejecting : " + curr);
            }
        }

    }
}
