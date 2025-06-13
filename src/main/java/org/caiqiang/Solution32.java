package org.caiqiang;

import java.util.Stack;

/**
 * @program: leetcode
 * @description:给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-04-14 16:40
 **/
public class Solution32 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
    
    

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.longestValidParentheses1("()()()(()))()()())))((()()()(()()))(()()()((()()))())(((())()())(()(()(()(())(((()())()))(()))()))))()())(()))))()()(())()()((())()()))))((()))))(()()((()(()(()())((())()()()()))()()()(())()()())((((()(())())))(((()(((()((((())())(()()()()(((((()))()(()(())))(((()()()()(()(((())(()(()()(()(()(())()))))))()))()())((()((((()(())(()()()(((((()())()))))())))((((()()()(()(())(((())(((()()((()((()(((()(()))(((())(((()((((()(())(((()((()(()())))))(()(()()(())))))()(()()((()))()))())())((())))()(())((((()((()))))()())()))((()(()())()())()()((()))())(()(()(())((((((()()((((())))())(((()()())))()(((()(()()((((())))))()()((((()(()()())(()(())()()()((()(()((((())))((((((())(()())()))))(()(()))()))))))(()()((()()()())(())))(((()))(()()()(()))((())()()()())()()(((())(()(())()()(()())((()()(((((())(()((((()(()()()(()))(()((((())()())()())())))())(((()(()((())()()((((()()()()))))))())())()(((((()())()(()()()()()(((())((((((()))(())()(()())(()(()())(()(())))())))(()()(()((((()()(())(()))()))(()))(()())())()))))))()()(())))))()))()(()())))((())(()()))()((()))()(())()()((((())()))((()(()))()(((()())()(()()((()())((((())()))))()(())())())())(((()(()())))((()))))()())))))(()((())))()())((()))()()))(())())()))()()((()(((())()()()((()()(()(())(()))())())(((()())(()())(()((()()()())()(()(((((((()()(((()(((((((())(()))))())()))))))))()(()(()((((())(()()(((()))()(())(((((((((()(()())())()(((()((()(((()(()()(()))(())))))))((("));
    }


    //暴力解法
    public int longestValidParentheses1(String s) {
        int length = s.length();
        if (length == 0 || length == 1){
            return 0;
        }
        if (length % 2 != 0) {
            length = length - 1;
        }

        while (length != 0) {
            for (int i = 0; i <= s.length() - length; i++) {
                int start = i;
                int end = i + length - 1;
                if (isTrue(s.substring(start, end + 1))) {
                    return end - start + 1;
                }
            }
            length = length - 2;
        }

        return 0;
    }

    private boolean isTrue(String subStr) {
        if (subStr.length() % 2 != 0) {
            return false;
        }
        if (subStr.charAt(0) != '(') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < subStr.length(); i++) {
            char c = subStr.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
