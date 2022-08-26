package com.Problem.Q1_Q499;

public class Solution0025_Reverse_Nodes_in_kGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newhead = reverseList(head, tail);
        head.next = reverseKGroup(tail, k);
        return newhead;
    }


    public ListNode reverseList(ListNode head, ListNode tail) {
        if (head == tail || head.next == tail) {
            return head;
        }
        ListNode temp = reverseList(head.next, tail);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {
        Solution0025_Reverse_Nodes_in_kGroup s = new Solution0025_Reverse_Nodes_in_kGroup();
        stringToListNode t = new stringToListNode();
        s.reverseKGroup(t.stringToListNode("[1,2,3,4,5]"), 2);
    }

}
