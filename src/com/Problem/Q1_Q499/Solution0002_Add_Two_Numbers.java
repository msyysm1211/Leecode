package com.Problem.Q1_Q499;

import java.util.List;

public class Solution0002_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        boolean flag = false;
        while (l1 != null && l2 != null) {
            int add = flag ? 1 : 0;
            int num = (l1.val + l2.val + add) % 10;
            ListNode node = new ListNode(num);
            tail.next = node;
            tail = node;
            flag = (l1.val + l2.val + add) / 10 >= 1 ? true : false;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                int add = flag ? 1 : 0;
                int num = (l1.val + add) % 10;
                ListNode node = new ListNode(num);
                tail.next = node;
                tail = node;
                flag = (l1.val + add) / 10 >= 1 ? true : false;
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
                int add = flag ? 1 : 0;
                int num = (l2.val + add) % 10;
                ListNode node = new ListNode(num);
                tail.next = node;
                tail = node;
                flag = (l2.val + add) / 10 >= 1 ? true : false;
                l2 = l2.next;
            }
        }
        if (flag) {
            ListNode node = new ListNode(1);
            tail.next = node;
            tail = node;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution0002_Add_Two_Numbers s = new Solution0002_Add_Two_Numbers();
        stringToListNode t = new stringToListNode();
        System.out.println(s.addTwoNumbers(t.stringToListNode("[5]"), t.stringToListNode("[5]")));
    }

}
