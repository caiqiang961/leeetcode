package org.caiqiang;

public class Solution32_1 {
    public static void main(String[] args) {
        Solution32_1 solution321 = new Solution32_1();
        System.out.println(solution321.longestValidParentheses("(())"));
    }
    public int longestValidParentheses(String s) {
        int result = 0;
        if (s.length() == 0 || s.length() == 1 ){
            return result;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        if (s.charAt(0) == '(' && s.charAt(1) == ')') {
            result = dp[1] = 2;
        } else {
            dp[1] = 0;
        }


        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
                continue;
            }
            // == ')'
            if (s.charAt(i - 1) == '(') {
                dp[i] = dp[i - 2] + 2;
            }else {
                //i-1 == ')'
                // (())
                // 0 0 2

                if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    if (i - dp[i-1] - 2 >= 0){
                        dp[i] = dp[i - dp[i-1] - 2] + dp[i-1] + 2;
                    }else {
                        dp[i] =  dp[i-1] + 2;
                    }

                }
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
