package com.Problem.Q500_Q999;

public class Solution0687_Longest_Univalue_Path {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        longestUnivaluePath(root.left);
        longestUnivaluePath(root.right);
        return max - 1;
    }

    int dfs(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (root.val == target) {
            left = dfs(root.left, target);
            right = dfs(root.right, target);
            max = Math.max(left + right + 1, max);
            return Math.max(left + 1, right + 1);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution0687_Longest_Univalue_Path s = new Solution0687_Longest_Univalue_Path();
        StringtoTreeNode t = new StringtoTreeNode();
        int x = s.longestUnivaluePath(t.stringToTreeNode("[5,4,5,1,1,null,5]"));
        System.out.println(x);
    }
}
