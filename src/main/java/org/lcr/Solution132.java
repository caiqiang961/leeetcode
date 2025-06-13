package org.lcr;

public class Solution132 {
    public int cuttingBamboo(int bamboo_len) {
        int a = 1000000007;
        int[] dp = new int[bamboo_len + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= bamboo_len; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                int max1 = Math.max(j*(i-j),j*dp[i-j]);
                max = Math.max(max1,max);
            }
            dp[i] = max;
        }
        return dp[bamboo_len];
    }

    // dp[i] = j * (i-j)  或  j * dp[i-j]
}
