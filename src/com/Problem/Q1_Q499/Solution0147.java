package com.Problem.Q1_Q499;

public class Solution0147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode sorted = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val >= sorted.val) {
                cur = cur.next;
                sorted = sorted.next;
            } else {
                ListNode temp = dummy;
                while (temp.next.val <= cur.val) {
                    temp = temp.next;
                }
                sorted.next = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                cur = sorted.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution0147 s = new Solution0147();
        s.insertionSortList(n1);
    }
}
