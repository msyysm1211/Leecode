package com.Problem.Q1_Q499;

import java.util.List;

public class Solution0236 {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }


    boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean l = dfs(root.left, p, q);
        boolean r = dfs(root.right, p, q);
        if (l == true && r == true || (root.val == p.val && (l == true || r == true)) || (root.val == q.val && (l == true || r == true))) {
            ans = root;
            return true;
        }
        if (root.val == p.val || root.val == q.val || (l || r)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root2 = new TreeNode(5);
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(6);
        TreeNode root5 = new TreeNode(2);
        TreeNode root6 = new TreeNode(0);
        TreeNode root7 = new TreeNode(8);
        TreeNode root8 = new TreeNode(7);
        TreeNode root9 = new TreeNode(4);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root5.left = root8;
        root5.right = root9;
        root3.left = root6;
        root3.right = root7;
        Solution0236 s = new Solution0236();
        s.lowestCommonAncestor(root, root4, root9);
    }
}
