package com.Problem.Q1_Q499;

import java.util.List;
import java.util.Random;

public class Solution0382_Linked_List_Random_Node {
    int count;
    ListNode root;
    Random random;

    public Solution0382_Linked_List_Random_Node(ListNode head) {
        root = head;
        count = getCount(head);
        random = new Random();
    }

    public int getRandom() {
        int t = random.nextInt(count);
        ListNode temp = root;
        for (int i = 0; i < t - 1; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    int getCount(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head.next = head2;
        head2.next = head3;
        Solution0382_Linked_List_Random_Node s = new Solution0382_Linked_List_Random_Node(head);
        s.getRandom();
    }
}
