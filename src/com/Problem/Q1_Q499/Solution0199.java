package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution0199 {
    List<Integer> res;
    Set<Integer> set = new HashSet<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<Integer>();
        dfs(0, root);
        return res;
    }

    void dfs(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        if (!set.contains(depth)) {
            res.add(root.val);
            set.add(depth);
        }
        dfs(depth + 1, root.right);
        dfs(depth + 1, root.left);
    }

    public static void main(String[] args) {
        Solution0199 s = new Solution0199();
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root2.right = root5;
        root3.right = root4;
        s.rightSideView(root);
    }
}
