package org.caiqiang;

import java.util.Arrays;

//59. 螺旋矩阵 II
//中等
//相关标签
//相关企业
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//示例 1：
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//示例 2：
//输入：n = 1
//输出：[[1]]
public class Solution59 {
    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        System.out.println(Arrays.deepToString(solution59.generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        int target = n * n;
        int[][] arr = new int[n][n];
        gen(n, target + 1, arr);
        return arr;
    }

    private void gen(int n, int target, int[][] arr) {
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1;
        int i = 0, j = 0;
        while (num < target) {

            //右移
            while (j <= right) {
                arr[i][j] = num;
                num++;
                j++;
            }
            j--;
            if (num == target) {
                return;
            }

            //下移
            i++;
            while (i <= bottom) {
                arr[i][j] = num;
                num++;
                i++;
            }
            i--;
            if (num == target) {
                return;
            }

            //左移
            j--;
            while (j >= left) {
                arr[i][j] = num;
                num++;
                j--;
            }
            j++;
            if (num == target) {
                return;
            }

            //上移
            i--;
            while (i >= top + 1) {
                arr[i][j] = num;
                num++;
                i--;
            }
            i++;
            if (num == target) {
                return;
            }
            //到第二层就位
            j++;

            top++;
            bottom--;
            left++;
            right--;
        }


    }
}
