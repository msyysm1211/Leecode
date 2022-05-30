package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        DFS(root, list);
        return list;
    }

    void DFS(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        DFS(root.left, list);
        DFS(root.right, list);
        list.add(root.val);
    }
}
