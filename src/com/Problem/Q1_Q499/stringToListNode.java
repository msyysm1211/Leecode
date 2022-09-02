package com.Problem.Q1_Q499;

public class stringToListNode {
    public ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static class Solution0441 {
        public int arrangeCoins(int n) {
            int l = 1;
            int r = n;
            while (l < r) {
                int m = (r - l + 1) / 2 + l;
                if ((long) m * (m + 1) / 2 <= (long) n) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }
    }
}
