package com.Problem.Q1_Q499;

public class Solution0109 {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    TreeNode helper(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode mid = getmiddle(start, end);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(start, mid);
        root.right = helper(mid.next, end);
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

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        //n3.next = n4;
        //n4.next = n5;
        Solution0109 s = new Solution0109();
        s.sortedListToBST(n1);
    }
}
