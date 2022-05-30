package com.Problem.Q1_Q499;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution0113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        DFS(root, path, targetSum, list);
        return list;
    }

    void DFS(TreeNode node, List<Integer> path, int targetSum, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        int s = path.size();
        List<Integer> ans = new ArrayList<Integer>();
        path.add(node.val);
        if (node.val == targetSum && node.left == null && node.right == null) {
            for (int i = 0; i <= path.size() - 1; i++) {
                ans.add(path.get(i));
            }
            list.add(ans);
        }
        DFS(node.left, path, targetSum - node.val, list);
        DFS(node.right, path, targetSum - node.val, list);
        path.remove(path.size() - 1);
    }

    public static void main(String args[]) {
        Solution0113 a = new Solution0113();
        TreeNode root = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(2);
        TreeNode g = new TreeNode(13);
        TreeNode h = new TreeNode(4);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);
        root.left = b;
        root.right = c;
        b.left = d;
        b.right = null;
        d.left = e;
        d.right = f;
        c.left = g;
        c.right = h;
        h.left = i;
        h.right = j;
        System.out.println(a.pathSum(root, 22));
    }
}
