package com.Problem.Q1_Q499;

public class Solution0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int count = 1;
        ListNode temp = dummy;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        ListNode l = dummy;
        for (int i = 0; i < count - n; i++) {
            l = l.next;
        }
        l.next = l.next.next;
        return dummy.next;
    }
}
