package org.caiqiang.jingdan;

// 完全背包问题
public class Main4 {
    public static void main(String[] args) {
        Main4 main4 =new Main4();
        System.out.println(main4.re(new int[]{1,2,3,4}, new int[]{2,4,4,5}, 5));
    }
    public int re(int[] ws,int[] rs,int v){
        // dp[1][1] = if j > w[i] max (dp[i-1][j],dp[i-1][j-w[i]]+r[i])
        //
        return 0;
    }
}
