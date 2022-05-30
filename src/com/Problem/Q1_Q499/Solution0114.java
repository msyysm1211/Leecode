package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

public class Solution0114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        DFS(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i).left = null;
        }
    }

    void DFS(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        DFS(node.left, list);
        DFS(node.right, list);
    }
}
