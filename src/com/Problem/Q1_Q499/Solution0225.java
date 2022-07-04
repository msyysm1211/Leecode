package com.Problem.Q1_Q499;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution0225 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public Solution0225() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String args[]) {
        Solution0225 s = new Solution0225();
        s.push(1);
        s.push(2);
    }
}
