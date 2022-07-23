package com.Problem.Q1_Q499;

public class Solution0143 {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode middle = getmiddle(dummy.next);
        ListNode temp = middle.next;
        middle.next = null;
        ListNode reversehead = reverse(temp);
        merge(dummy.next, reversehead);

    }

    void merge(ListNode root1, ListNode root2) {
        ListNode temp1;
        ListNode temp2;
        while (root1 != null || root2 != null) {
            temp1 = root1.next;
            temp2 = root2.next;

            root1.next = root2;
            root2.next = temp1;
            root1 = temp1;
            root2 = temp2;
        }
    }

    ListNode getmiddle(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode reverse(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode newhead = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return newhead;
    }

    public static void main(String[] args) {
        Solution0143 s = new Solution0143();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        s.reorderList(n1);
    }
}
