package com.Problem.Q500_Q999;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0655_Print_Binary_Tree {
    List<List<String>> res;

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public List<List<String>> printTree(TreeNode root) {
        res = new ArrayList<>();
        int height = dfs(root);
        int m = (int) (Math.pow(2, height) - 1);
        for (int i = 0; i < height; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                res.get(i).add("");
            }
        }
        helper(0, 0, m, root, height);
        return res;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    void helper(int depth, int start, int end, TreeNode root, int height) {
        if (depth == height || root == null) {
            return;
        }
        List<String> layer = res.get(depth);
        int rootindex = start + (end - start) / 2;
        layer.set(rootindex, String.valueOf(root.val));
        helper(depth + 1, start, rootindex - 1, root.left, height);
        helper(depth + 1, rootindex + 1, end, root.right, height);
    }

    public static void main(String[] args) {
        Solution0655_Print_Binary_Tree s = new Solution0655_Print_Binary_Tree();
        s.printTree(stringToTreeNode("[1,2,3,null,4]"));
    }
}
