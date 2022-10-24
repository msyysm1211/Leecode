package com.Problem.Q500_Q999;

import java.util.ArrayList;
import java.util.List;

public class Solution0707_Design_Linked_List {
    List list;
    ListNode dummy;
    int size = 0;

    public Solution0707_Design_Linked_List() {
        list = new ArrayList();
        dummy = new ListNode(-1);
    }

    public int get(int index) {
        index = index + 1;
        if (index > size) {
            return -1;
        }
        ListNode head = dummy;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        ListNode temp = dummy;
        if (index > size) {
            return;
        }
        if (index < 0) {
            addAtHead(val);
            return;
        }
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        ListNode node = new ListNode(val);
        if (temp != null) {
            node.next = temp.next;
            temp.next = node;
        } else {
            dummy.next = node;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        ListNode temp = dummy;
        if (index < size && index >= 0) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            size--;
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        Solution0707_Design_Linked_List s = new Solution0707_Design_Linked_List();
        s.addAtIndex(1, 3);
        System.out.println(s.get(0));


    }

}
