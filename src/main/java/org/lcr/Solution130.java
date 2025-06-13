package org.lcr;

public class Solution130 {
    public static void main(String[] args) {
        Solution130 solution130 = new Solution130();
        System.out.println(solution130.wardrobeFinishing(4, 7, 5));
        System.out.println(solution130.wardrobeFinishing(16, 8, 4));
    }
    private int result = 0;

    public int wardrobeFinishing(int m, int n, int cnt) {
        boolean[][] grid = new boolean[m][n];
        DFS(grid, cnt, 0, 0);
        return result;
    }

    private void DFS(boolean[][] grid, int cnt, int x, int y) {
        if (x >= grid.length || y >= grid[0].length) {
            return;
        }
        if (grid[x][y]) {
            return;
        }
        if (digit(x) + digit(y) > cnt) {
            return;
        }
        result++;
        grid[x][y] = true;
        DFS(grid, cnt, x + 1, y);
        DFS(grid, cnt, x, y + 1);
    }

    private int digit(int a) {
        if (a < 10) return a;
        int result = 0;
        while (a >= 10) {
            result = result + a % 10;
            a = a / 10;
        }
        return result + a;
    }
}
