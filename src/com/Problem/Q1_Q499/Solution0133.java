package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a Node.
public class Solution0133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Node, Node> map = new HashMap<Node, Node>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newnode = new Node(node.val, new ArrayList<>());
        map.put(node, newnode);
        for (Node neighbor : node.neighbors) {
            newnode.neighbors.add(cloneGraph(neighbor));
        }
        return newnode;
    }
}
