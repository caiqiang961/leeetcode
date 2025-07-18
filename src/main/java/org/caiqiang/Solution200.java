package org.caiqiang;

//200. 岛屿数量
//中等
//相关标签
//相关企业
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。
//
//
//
//示例 1：
//
//输入：grid = [
//  {'1','1','1','1','0'],
//  {'1','1','0','1','0'],
//  {'1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
//示例 2：
//
//输入：grid = [
//  {'1','1','0','0','0'],
//  {'1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
//
//
//提示：
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 300
//grid[i][j] 的值为 '0' 或 '1'
public class Solution200 {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        Solution200 solution200 = new Solution200();
        System.out.println(solution200.numIslands(arr));
    }

    int count = 0;

    public int numIslands(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                start(grid, i, j, true);
            }
        }
        return count;
    }

    private void start(char[][] grid, int i, int j, boolean flag) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }
        grid[i][j] = '2';
        if (flag) count++;
        start(grid, i + 1, j, false);
        start(grid, i - 1, j, false);
        start(grid, i, j + 1, false);
        start(grid, i, j - 1, false);
    }
}
