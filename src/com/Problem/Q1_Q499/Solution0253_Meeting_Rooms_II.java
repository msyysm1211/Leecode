package com.Problem.Q1_Q499;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution0253_Meeting_Rooms_II {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int count = 0;
        for (int[] interval : intervals) {
            if (minheap.isEmpty()) {
                minheap.add(interval[1]);
                count++;
            } else {
                int top = minheap.peek();
                if (top <= interval[0]) {
                    minheap.poll();
                    minheap.add(interval[1]);
                } else {
                    count++;
                    minheap.add(interval[1]);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution0253_Meeting_Rooms_II s = new Solution0253_Meeting_Rooms_II();
        int t = s.minMeetingRooms(new int[][]{{9, 10}, {4, 9}, {4, 17}});
        System.out.println(t);
    }
}
