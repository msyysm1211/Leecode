package com.Problem.Q1_Q499;

import java.util.Stack;

public class Solution0232 {
}

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> stack2;

    public MyQueue() {
        stack = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        if (stack.size() == 0) {
            stack.push(x);
        } else {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            stack2.push(x);
            while (!stack2.isEmpty()) {
                stack.push(stack2.pop());
            }
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}