package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0095 {

    public List<TreeNode> generateTrees(int n) {
        return n == 0 ? null : dfs(1, n);
    }

    List<TreeNode> dfs(int start, int end) {
        List<TreeNode> allnode = new ArrayList<TreeNode>();
        if (start > end) {
            allnode.add(null);
            return allnode;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs(start, i - 1);
            List<TreeNode> right = dfs(i + 1, end);
            for (TreeNode leftnode : left) {
                for (TreeNode rightnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftnode;
                    root.right = rightnode;
                    allnode.add(root);
                }
            }
        }
        return allnode;
    }

    public static void main(String[] args) {
        Solution0095 s = new Solution0095();
        s.generateTrees(3);
    }
}
