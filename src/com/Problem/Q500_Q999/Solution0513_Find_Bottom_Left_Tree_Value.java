package com.Problem.Q500_Q999;

public class Solution0513_Find_Bottom_Left_Tree_Value {
    int maxdepth = -1;
    int res = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > maxdepth) {
            res = root.val;
            maxdepth = depth;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

    }
}
