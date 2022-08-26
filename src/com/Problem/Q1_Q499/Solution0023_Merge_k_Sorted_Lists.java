package com.Problem.Q1_Q499;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution0023_Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null)
                queue.add(list);
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
            if (temp.next != null) {
                queue.add(temp.next);
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        Solution0023_Merge_k_Sorted_Lists s = new Solution0023_Merge_k_Sorted_Lists();
        stringToListNode t = new stringToListNode();
        ListNode n1 = t.stringToListNode("[3,4,5]");
        ListNode n2 = t.stringToListNode("[1,3,4]");
        ListNode n3 = t.stringToListNode("[2,6]");
        ListNode[] lists = new ListNode[]{n1, n2, n3};
        s.mergeKLists(lists);
    }

}