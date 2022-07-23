package com.Problem.Q1_Q499;

public class Solution0086 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummynode = new ListNode(-1);
        dummynode.next = head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode big = new ListNode(-1);
        ListNode small = new ListNode(-1);
        ListNode bigroot = big;
        ListNode smallroot = small;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigroot.next;
        return smallroot.next;
    }

    public static void main(String[] args) {
        Solution0086 s = new Solution0086();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        s.partition(n1, 3);
    }
}
