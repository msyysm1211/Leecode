package com.Problem.Q500_Q999;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0817_Linked_List_Components {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }
        boolean flag = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (flag == false) {
                    res++;
                    flag = true;
                }
            } else {
                flag = false;
            }
            head = head.next;
        }
        return res;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        stringToArray t = new stringToArray();
        int[] nodeValues = t.stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static void main(String[] args) {
        Solution0817_Linked_List_Components s = new Solution0817_Linked_List_Components();
        System.out.println(s.numComponents(stringToListNode("[0,1,2,3]"), new int[]{0, 1, 3}));
    }

}
