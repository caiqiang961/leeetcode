package org.lcr;


// dp[0] = 0
// dp[1] = 1
// dp[2] =
// dp[i] = 拆分为2个：j * (i-j) 或 拆分为多个 j * dp[i-j]  (// 可以不砍,)
public class Solution131_2 {
    public static void main(String[] args) {
        Solution131_2 solution131_2 = new Solution131_2();
        System.out.println(solution131_2.cuttingBamboo(2));
    }

    public int cuttingBamboo(int bamboo_len) {
        int[] dp = new int[bamboo_len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= bamboo_len; i++) {
            int result = 0;
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    //不砍的时候 dp[i - j]不对，所以必须砍，不砍没法算
                    result = Math.max(result, Math.max(i - j, dp[i - j]));
                } else {
                    result = Math.max(result, Math.max(j * (i - j), j * dp[i - j]));
                }
            }
            dp[i] = result;
        }
        return dp[bamboo_len];
    }

}
