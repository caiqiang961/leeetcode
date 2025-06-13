package org.caiqiang;

public class Solution72 {
    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        System.out.println(solution72.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                char w1 = word1.charAt(i - 1);
                char w2 = word2.charAt(j - 1);
                int curr;
                if (w1 != w2) {
                    curr = dp[i - 1][j - 1];
                } else {
                    curr = dp[i - 1][j - 1] - 1;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), curr) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
