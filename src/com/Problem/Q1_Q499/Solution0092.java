package com.Problem.Q1_Q499;

public class Solution0092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode temp = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            temp = temp.next;// left
        }
        ListNode leftpoint = temp.next;//left
        ListNode rightpoint = temp;
        for (int i = 0; i < right - left + 1; i++) {
            rightpoint = rightpoint.next;//right
        }
        ListNode cur = rightpoint.next;
        rightpoint.next = null;
        temp.next = null;
        reverseList(leftpoint);
        temp.next = rightpoint;
        leftpoint.next = cur;
        return dummyNode.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newpoint = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newpoint;
    }

    public static void main(String args[]) {
        Solution0092 s = new Solution0092();
        /*ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;*/
        ListNode head = new ListNode(1);
        //ListNode node1 = new ListNode(2);
        //head.next = node1;
        s.reverseBetween(head, 1, 1);
    }
}
