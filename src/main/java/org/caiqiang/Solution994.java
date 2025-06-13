package org.caiqiang;

public class Solution994 {
    public static void main(String[] args) {
        Solution994 solution994 = new Solution994();
        System.out.println(solution994.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    public int orangesRotting(int[][] grid) {
        int result = 2;
        while (startBfs(grid, result)) {
            result++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return result - 2;
    }

    private boolean startBfs(int[][] grid, int k) {
        boolean flag = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == k) {
                    // == 2
                    boolean b1 = bfs(grid, i + 1, j, k + 1);
                    boolean b2 = bfs(grid, i - 1, j, k + 1);
                    boolean b3 = bfs(grid, i, j + 1, k + 1);
                    boolean b4 = bfs(grid, i, j - 1, k + 1);
                    boolean re = b1 || b2 || b3 || b4;
                    if (re) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    private boolean bfs(int[][] grid, int i, int j, int k) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = k;
            return true;
        }
        return false;
    }
}
