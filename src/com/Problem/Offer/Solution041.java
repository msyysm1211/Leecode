package com.Problem.Offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution041 {
    int n;
    Queue<Integer> queue;
    double sum;

    /**
     * Initialize your data structure here.
     */
    public Solution041(int size) {
        n = size;
        sum = 0;
        queue = new ArrayDeque<Integer>();
    }

    public double next(int val) {
        if (queue.size() == n) {
            sum -= queue.poll();
        }
        sum += val;
        queue.add(val);
        return sum / queue.size();
    }

    public static void main(String[] args) {
        Solution041 s = new Solution041(3);
        double t1 = s.next(1);
        double t2 = s.next(10);
        double t3 = s.next(3);
        double t4 = s.next(5);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
    }
}
