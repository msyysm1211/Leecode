package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        DFS(root, res);
        return res;
    }

    void DFS(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        DFS(root.left, res);
        DFS(root.right, res);
    }

}
