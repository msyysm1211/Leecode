package com.Problem.Q1000_Q1499;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution1302 {
    int sum = 0;
    int maxdepth = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return bfs(root);
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == maxdepth) {
            sum += root.val;
        } else if (depth > maxdepth) {
            sum = root.val;
            maxdepth = depth;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    int bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if (root == null) {
            return 0;
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return sum;
    }

    int help(int n) {
        if (n <= 1) {
            return 1;
        }
        return help(n - 1) + help(n - 2);
    }

    public static void main(String[] args) {
        Solution1302 s = new Solution1302();
        System.out.println(s.deepestLeavesSum(null));
        System.out.println(s.help(38));
    }

}
