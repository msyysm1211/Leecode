package com.Problem.Q1_Q499;

import java.util.List;

public class Solution0061_Rotate_List {
    int count = 1;

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = findListNodeTail(head);
        ListNode temp = head;
        tail.next = head;
        int n = k % count;
        for (int i = 0; i < count - n; i++) {
            temp = temp.next;
        }
        dummy.next = temp;
        for (int i = 0; i < count - 1; i++) {
            temp = temp.next;
        }
        temp.next = null;
        return dummy.next;
    }

    ListNode findListNodeTail(ListNode head) {
        while (head != null && head.next != null) {
            head = head.next;
            count++;
        }
        return head;
    }


    public static void main(String[] args) {
        Solution0061_Rotate_List s = new Solution0061_Rotate_List();
        stringToListNode t = new stringToListNode();
        ListNode head = t.stringToListNode("[1,2,3,4,5]");
        System.out.println(s.rotateRight(head, 2));
    }


}
