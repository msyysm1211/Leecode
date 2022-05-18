package com.Problem.Q1_Q499;


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

class Solution0108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getroot(nums, 0, nums.length - 1);
    }

    TreeNode getroot(int[] nums, int start, int end) {
        if (end > start) {
            return null;
        }
        TreeNode root = new TreeNode();
        int n = end + start;
        root.val = nums[n / 2];
        root.left = getroot(nums, start, n / 2 - 1);
        root.right = getroot(nums, n / 2 + 1, end);
        return root;
    }

    public static void main(String args[]) {
        Solution0108 a = new Solution0108();
        a.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
