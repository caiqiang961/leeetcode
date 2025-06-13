package org.caiqiang;

import java.util.ArrayDeque;
import java.util.Deque;

//62. 不同路径
//中等
//相关标签
//相关企业
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
//问总共有多少条不同的路径？
//
//
//
//示例 1：
//
//
//输入：m = 3, n = 7
//输出：28
//示例 2：
//
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
//示例 3：
//
//输入：m = 7, n = 3
//输出：28
//示例 4：
//
//输入：m = 3, n = 3
//输出：6
//
//
//提示：
//
//1 <= m, n <= 100
//题目数据保证答案小于等于 2 * 109
public class Solution62 {
    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
//        System.out.println(solution62.uniquePaths(23, 12));
        System.out.println(solution62.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {

        return uniquePathsDonTaiGuiFua(m,n);
    }

    public int uniquePathsDFS(int m, int n) {
        int[][] arr = new int[m][n];
        arr[m - 1][n - 1] = -1;
        startDFS(arr, 0, 0, m, n);
        return dfsCount;
    }
    public int uniquePathsDonTaiGuiFua(int m, int n) {
        int[][] arr = new int[m][n];
        arr[0][0] = 1;
        return  startDonTaiGuiHua(arr,m - 1, n - 1);
    }

    int dfsCount = 0;
    int bfsCount = 0;
    int DonTaiGuiHuaCount = 0;

    // dfs 时间太长
    private void startDFS(int[][] arr, int x, int y, int m, int n) {
        if (x >= m || y >= n) {
            return;
        }
        if (arr[x][y] == -1) {
            dfsCount++;
            return;
        }
        if (arr[x][y] == 0) {
            arr[x][y] = 1;
            startDFS(arr, x + 1, y, m, n);
            startDFS(arr, x, y + 1, m, n);
            arr[x][y] = 0;
        }
    }

    //bfs不对，超级多的重复计算，导致几乎死循环()
    private void startBFS(int[][] arr, int m, int n) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{0, 0});
        arr[0][0] = 1;
        while (!deque.isEmpty()) {

            int[] ints = deque.pollFirst();
            int x = ints[0];
            int y = ints[1];

            if (x + 1 < m) {

                deque.addLast(new int[]{x + 1, y});
            }
            if (y + 1 < n) {
                deque.addLast(new int[]{x, y + 1});
            }
        }
    }

    // 一个倒着来的动态规划，时间太长
    private int startDonTaiGuiHua(int[][] arr, int x, int y) {
        if (x < 0 || y < 0){
            return 0;
        }
        if (x == 0 && y == 0){
            return arr[0][0];
        }
        arr[x][y] = startDonTaiGuiHua(arr, x - 1, y) + startDonTaiGuiHua(arr, x, y - 1);
        return arr[x][y];
    }
    // 完美正常的动态规划
    private int startDonTaiGuiHua2(int[][] arr, int m, int n){
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];
    }

    private int startx(int m,int n){
        int result = 0;
        for (int i = n; i >= 1; i--) {
            result = result + i;
        }
        return result;
    }

}
