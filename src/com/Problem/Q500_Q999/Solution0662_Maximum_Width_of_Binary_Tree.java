package com.Problem.Q500_Q999;

import java.util.*;

public class Solution0662_Maximum_Width_of_Binary_Tree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        List<Map<TreeNode, Integer>> res = new ArrayList<>();
        queue.add(root);
        map.put(root, 1);
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int nodeindex = map.get(node);
                if (node.left != null) {
                    queue.add(node.left);
                    map.put(node.left, nodeindex * 2);
                    list.add(nodeindex * 2);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    map.put(node.right, nodeindex * 2 + 1);
                    list.add(nodeindex * 2 + 1);
                }
            }
            if (!list.isEmpty())
                max = Math.max(max, list.get(list.size() - 1) - list.get(0) + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution0662_Maximum_Width_of_Binary_Tree s = new Solution0662_Maximum_Width_of_Binary_Tree();
        StringtoTreeNode t = new StringtoTreeNode();
        System.out.println(s.widthOfBinaryTree(t.stringToTreeNode("[1,3,2,5,3,null,9]")));
    }

}
