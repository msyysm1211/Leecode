package com.Problem.Q1_Q499;

import java.util.ArrayDeque;
import java.util.Queue;

// Definition for a Node.


public class Solution0117 {
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<Node>();
        if (root == null) {
            return null;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                node.next = queue.peek();
            }
        }
        return root;
    }
}
