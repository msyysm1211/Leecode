package com.Problem.Q500_Q999;


import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution0589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, list);
        return list;
    }

    void dfs(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i), list);
        }
    }
}
