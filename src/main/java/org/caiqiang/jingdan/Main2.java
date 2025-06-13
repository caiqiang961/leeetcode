package org.caiqiang.jingdan;

// 0-1背包问题
public class Main2 {

    //dp[i][j]表示当可以放入前i个物体时 背包容量为j时，的最大价格
    // if i == 0 dp[i][j] = 0;
    // if j == 0 dp[i][j] = 0;
    // dp[1][1] = ws[i]<=j?rs[i]:0
    // dp[1][2] = ws[i]<=j?rs[i]:0
    // ...
    // dp[2][1] = dp[i-1][j] + w[i]>j?0:()

    // dp[i][j] = w[i] > j ? dp[i-1][j] : max(dp[i-1][j-ws[i]] + rs[i] , dp[i-1][j])
    public static void main(String[] args) {
        Main2 main2 =new Main2();
        System.out.println(main2.re(new int[]{1,2,3,4}, new int[]{2,4,4,5}, 5));
    }
    public int re(int[] ws,int[] rs,int v){
        // ws重量 rs价格
        int[][] dp = new int[ws.length+1][v+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int wsIndex = i-1;
                if (ws[wsIndex] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j-ws[wsIndex]]+rs[i-1],dp[i-1][j]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        return dp[ws.length][v];
    }
}
