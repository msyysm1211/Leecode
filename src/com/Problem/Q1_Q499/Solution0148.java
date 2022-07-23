package com.Problem.Q1_Q499;

public class Solution0148 {
    public ListNode sortList(ListNode head) {
        return (sortList(head, null));
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode middle = middle(head, tail);
        ListNode sortedleft = sortList(head, middle);
        ListNode sortedright = sortList(middle, tail);
        ListNode sortedroot = merge(sortedleft, sortedright);
        return sortedroot;
    }

    ListNode middle(ListNode root, ListNode tail) {
        ListNode slow = root;
        ListNode fast = root;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return slow;
    }

    ListNode merge(ListNode root1, ListNode root2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode temp1 = root1;
        ListNode temp2 = root2;
        while (temp1 != null & temp2 != null) {
            if (temp1.val > temp2.val) {
                temp.next = temp2;
                temp2 = temp2.next;
            } else {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
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
        Solution0148 s = new Solution0148();
        s.sortList(n1);
    }
}
