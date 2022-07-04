package com.Problem.Q1_Q499;

public class Solution0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        int cur = head.val;
        while (head.next != null) {
            if (head.next.val == cur) {
                head.next = head.next.next;
            } else {
                cur = head.next.val;
                head = head.next;
            }
        }
        return temp.next;
    }
}
