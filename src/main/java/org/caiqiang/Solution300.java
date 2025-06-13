package org.caiqiang;

public class Solution300 {
    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
//        System.out.println(solution300.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
//        System.out.println(solution300.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        System.out.println(solution300.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }

    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i < nums.length; i++) {
            int flag = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                flag = Math.max( nums[j] < nums[i] ? dp[j][0] + 1 : 1,flag);
            }
            dp[i][0] = flag;
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
