package org.caiqiang;


public class Solution200_1 {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && dfs(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return true;
        }
        if (grid[x][y] == '0' || grid[x][y] == '2') {
            return true;
        }

        if (grid[x][y] == '1') {
            grid[x][y] = '2';
        }

        return dfs(grid, x + 1, y) &&
                dfs(grid, x - 1, y) &&
                dfs(grid, x, y + 1) &&
                dfs(grid, x, y - 1);
    }
}
