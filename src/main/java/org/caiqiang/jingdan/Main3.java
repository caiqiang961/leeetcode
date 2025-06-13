package org.caiqiang.jingdan;

import java.util.Arrays;
import java.util.Scanner;

// 分组背包问题
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupNum = scanner.nextInt();
        int v = scanner.nextInt();
        int[][] ws = new int[groupNum][100];
        int[][] rs = new int[groupNum][100];
        int[][] gs = new int[groupNum][1];
        for (int i = 0; i < groupNum; i++) {
            int count = scanner.nextInt();
            gs[i][0] = count;
            for (int j = 0; j < count; j++) {
                ws[i][j] = scanner.nextInt();
                rs[i][j] = scanner.nextInt();
            }
        }
        Main3 main3 = new Main3();
        System.out.println(main3.re(ws, rs, gs, v, groupNum));
    }

    private int re(int[][] ws, int[][] rs, int[][] gs, int v, int groupNum) {
        int[][] dp = new int[groupNum + 1][v + 1];
        for (int i = 1; i < dp.length; i++) {
            int groupIndex = i - 1;
            System.out.println("第" + groupIndex + "组：" + gs[groupIndex][0]);
            System.out.println("体积：" + Arrays.toString(ws[groupIndex]));
            System.out.println("价格：" + Arrays.toString(rs[groupIndex]));
            //
            for (int j = 1; j < dp[i].length; j++) {
                int curr = subRe(gs[groupIndex][0], ws[groupIndex], rs[groupIndex], i, j, dp);
                dp[i][j] = Math.max(dp[i - 1][j], curr);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[groupNum][v];
    }

    private int subRe(int count, int[] ws, int[] rs, int i, int j, int[][] dp) {
        int result = 0;

        for (int k = 0; k < count; k++) {
            if (j - ws[k] >= 0) {
                result = Math.max(result, dp[i - 1][j - ws[k]] + rs[k]);
            }
        }
        return result;
    }

}