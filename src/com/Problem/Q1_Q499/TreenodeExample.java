package com.Problem.Q1_Q499;

public class TreenodeExample {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root2.right = root5;
        root3.right = root4;
    }
}
