package com.Problem;

import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter { //question
    public static Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>() {
        };
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
    public static void main(String args[]){
        RecentCounter a =new RecentCounter();
        int b= a.ping(1);
        int c= a.ping(2);
        int d= a.ping(1563);
        int e= a.ping(4054);
        int g= a.ping(4152);
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */