package org.caiqiang;

public class Solution1143 {
    // s1的第i个字符 == s2的第j个字符
    // s1[i-1] == s2[j-1]  时， dp[i][j] = dp[i-1][j-1] + 1
    // s1[i-1] != s2[j-1]  时， dp[i][j] = max(dp[i-1][j],dp[i][j-1])
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            char c = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char c1 = text2.charAt(j - 1);
                if (c == c1) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j ],dp[i][j-1]);
                }
            }
        }
    return dp[text1.length()][text2.length()];
    }
}
