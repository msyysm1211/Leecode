package com.Problem.Q1_Q499;

public class Solution0109_2 {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    TreeNode helper(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode middle = getmiddle(start, end);
        TreeNode root = new TreeNode(middle.val);
        root.left = helper(start, middle);
        root.right = helper(middle.next, end);
        return root;
    }


    ListNode getmiddle(ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
