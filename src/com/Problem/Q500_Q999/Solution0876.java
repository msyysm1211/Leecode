package com.Problem.Q500_Q999;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution0876 {

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = new ListNode();
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        temp = head;
        for (int i = 0; i <= count / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
