package com.Problem.Q500_Q999;

import java.util.PriorityQueue;

/*
* 769. Max Chunks To Make Sorted
You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.



Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
*
* */
public class Solution0769_Max_Chunks_To_Make_Sorted {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int res = 0;
        PriorityQueue<Integer> stack = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.poll();
                count++;
            }
            stack.add(arr[i]);
            res += count;
        }
        return res + stack.size();
    }

    public static void main(String[] args) {
        Solution0769_Max_Chunks_To_Make_Sorted s = new Solution0769_Max_Chunks_To_Make_Sorted();
        System.out.println(s.maxChunksToSorted(new int[]{3, 4, 2, 1, 0}));
    }

}
