//package com.Problem.Q1_Q499;
//
///*
//* Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
// 
//
//Example 1:
//
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
//Example 2:
//
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
//Example 3:
//
//Input: s = ""
//Output: 0
// 
//
//Constraints:
//
//0 <= s.length <= 3 * 104
//s[i] is '(', or ')'.
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/longest-valid-parentheses
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
//public class Solution0032_Longest_Valid_Parentheses {
//    public int longestValidParentheses(String s) {
//
//    }
//}
///*我们定义 \textit{dp}[i]dp[i] 表示以下标 ii 字符结尾的最长有效括号的长度。我们将 \textit{dp}dp 数组全部初始化为 00 。显然有效的子串一定以 \text{‘)’}‘)’ 结尾，因此我们可以知道以 \text{‘(’}‘(’ 结尾的子串对应的 \textit{dp}dp 值必定为 00 ，我们只需要求解 \text{‘)’}‘)’ 在 \textit{dp}dp 数组中对应位置的值。
//
//我们从前往后遍历字符串求解 \textit{dp}dp 值，我们每两个字符检查一次：
//
//s[i] = \text{‘)’}s[i]=‘)’ 且 s[i - 1] = \text{‘(’}s[i−1]=‘(’，也就是字符串形如 “……()”“……()”，我们可以推出：
//
//\textit{dp}[i]=\textit{dp}[i-2]+2
//dp[i]=dp[i−2]+2
//
//我们可以进行这样的转移，是因为结束部分的 "()" 是一个有效子字符串，并且将之前有效子字符串的长度增加了 22 。
//
//s[i] = \text{‘)’}s[i]=‘)’ 且 s[i - 1] = \text{‘)’}s[i−1]=‘)’，也就是字符串形如 “……))”“……))”，我们可以推出：
//如果 s[i - \textit{dp}[i - 1] - 1] = \text{‘(’}s[i−dp[i−1]−1]=‘(’，那么
//
//\textit{dp}[i]=\textit{dp}[i-1]+\textit{dp}[i-\textit{dp}[i-1]-2]+2
//dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
//
//我们考虑如果倒数第二个 \text{‘)’}‘)’ 是一个有效子字符串的一部分（记作 sub_ssub
//s
//​
// ），对于最后一个 \text{‘)’}‘)’ ，如果它是一个更长子字符串的一部分，那么它一定有一个对应的 \text{‘(’}‘(’ ，且它的位置在倒数第二个 \text{‘)’}‘)’ 所在的有效子字符串的前面（也就是 sub_ssub
//s
//​
//  的前面）。因此，如果子字符串 sub_ssub
//s
//​
//  的前面恰好是 \text{‘(’}‘(’ ，那么我们就用 22 加上 sub_ssub
//s
//​
//  的长度（\textit{dp}[i-1]dp[i−1]）去更新 \textit{dp}[i]dp[i]。同时，我们也会把有效子串 “(sub_s)”“(sub
//s
//​
// )” 之前的有效子串的长度也加上，也就是再加上 \textit{dp}[i-\textit{dp}[i-1]-2]dp[i−dp[i−1]−2]。
//
//最后的答案即为 \textit{dp}dp 数组中的最大值。
//class Solution {
//    public int longestValidParentheses(String s) {
//        int maxans = 0;
//        int[] dp = new int[s.length()];
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                if (s.charAt(i - 1) == '(') {
//                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
//                }
//                maxans = Math.max(maxans, dp[i]);
//            }
//        }
//        return maxans;
//    }
//}
//
//作者：LeetCode-Solution
//链接：https://leetcode.cn/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//作者：LeetCode-Solution
//链接：https://leetcode.cn/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。