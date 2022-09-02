package com.Problem.Q1_Q499;

public class Solution0437_Path_Sum_III {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        count += dfs(root, targetSum);
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        return count;
    }

    int dfs(TreeNode root, long targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        if (targetSum == root.val) {
            ret++;
        }
        ret += dfs(root.left, (long) targetSum - root.val);
        ret += dfs(root.right, (long) targetSum - root.val);
        return ret;
    }

    public static void main(String[] args) {
        Solution0437_Path_Sum_III s = new Solution0437_Path_Sum_III();
        StringToTreeNode t = new StringToTreeNode();
        int k = s.pathSum(t.stringToTreeNode("[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]"), 8);
        System.out.println(k);
    }
}
