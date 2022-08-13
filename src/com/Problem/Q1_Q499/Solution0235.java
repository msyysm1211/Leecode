package com.Problem.Q1_Q499;

public class Solution0235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == q.val || root.val == p.val) {
            return root;
        }
        if (root.val > p.val && root.val < q.val) {
            return root;
        }
        if (root.val < p.val && root.val > q.val) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            root = helper(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            root = helper(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(8);
        TreeNode root4 = new TreeNode(0);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(7);
        TreeNode root7 = new TreeNode(9);
        TreeNode root8 = new TreeNode(3);
        TreeNode root9 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root5.left = root8;
        root5.right = root9;
        root3.left = root6;
        root3.right = root7;
        Solution0235 s = new Solution0235();
        s.lowestCommonAncestor(root, root2, root5);
    }
}
