package com.Problem.Q1_Q499;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution0155 {
    Deque<Integer> queue;
    Deque<Integer> min;

    public Solution0155() {
        queue = new ArrayDeque<Integer>();
        min = new ArrayDeque<Integer>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        queue.push(val);
        min.push(Math.min(min.peek(), val));
    }

    public void pop() {
        queue.pop();
        min.pop();
    }

    public int top() {
        return queue.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
