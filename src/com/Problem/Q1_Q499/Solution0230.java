package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0230 {
    int size;
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        size = k;
        dfs(root);
        return list.get(k - 1);
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(2);
        root1.left = root2;
        root1.right = root3;
        root2.right = root4;
        Solution0230 s = new Solution0230();
        int t = s.kthSmallest(root1, 3);
        System.out.println(t);
    }
}
