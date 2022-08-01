package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0234 {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> left = new Stack<ListNode>();
        Queue<ListNode> right = new ArrayDeque<ListNode>();
        if (head.next == null) {
            return true;
        }
        ListNode middle = getmiddle(head);
        while (head != middle.next) {
            left.push(head);
            head = head.next;
        }
        while (head != null) {
            right.add(head);
            head = head.next;
        }
        if (left.size() == right.size()) {
            while (!left.isEmpty()) {
                ListNode l = left.pop();
                ListNode r = right.poll();
                if (l.val != r.val) {
                    return false;
                }
            }
        } else {
            left.pop();
            while (!left.isEmpty()) {
                ListNode l = left.pop();
                ListNode r = right.poll();
                if (l.val != r.val) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null)
            return true;
        ListNode before = getmiddle(head);
        ListNode behind = reverse(before.next);
        ListNode p1 = head;
        ListNode p2 = behind;
        boolean res = true;
        while (res && p2 != null) {
            if (p1.val != p2.val) {
                res = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return res;
    }

    ListNode getmiddle(ListNode root) {
        if (root == null) {
            return null;
        }
        if (root.next == null) {
            return root;
        }
        ListNode slow = root;
        ListNode fast = root;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverse(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode head = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution0234 s = new Solution0234();
        System.out.println(s.isPalindrome2(n1));
    }
}
