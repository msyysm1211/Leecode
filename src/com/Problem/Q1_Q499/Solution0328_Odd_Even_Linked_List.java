package com.Problem.Q1_Q499;

import java.util.List;

public class Solution0328_Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        even.next = null;
        odd.next = temp;
        return head;
    }

    public static void main(String[] args) {
        Solution0328_Odd_Even_Linked_List s = new Solution0328_Odd_Even_Linked_List();
        stringToListNode l = new stringToListNode();
        s.oddEvenList(l.stringToListNode("[1,2,3,4,5,6,7,8]"));
    }
}
