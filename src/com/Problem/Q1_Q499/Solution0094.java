package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Solution0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        BFS(root, res);
        return res;
    }

    void BFS(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        BFS(root.left, res);
        res.add(root.val);
        BFS(root.right, res);
    }
}
