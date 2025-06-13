package org.caiqiang;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution200_2 {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        Solution200_2 solution200 = new Solution200_2();
        System.out.println(solution200.numIslands(arr));
    }
    public int numIslands(char[][] grid) {
        int result = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    deque.addLast(new int[]{i, j});
                    bfs(deque, grid);
                    result++;
                }
            }
        }
        return result;
    }

    private void bfs(Deque<int[]> deque, char[][] grid) {

        while (!deque.isEmpty()) {
            int[] ints = deque.pollFirst();
            int x = ints[0];
            int y = ints[1];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                continue;
            }
            if (grid[x][y] == '0' || grid[x][y] == '2') {
                continue;
            }
            if (grid[x][y] == '1') {
                grid[x][y] = '2';
            }
            deque.addLast(new int[]{x + 1, y});
            deque.addLast(new int[]{x - 1, y});
            deque.addLast(new int[]{x, y + 1});
            deque.addLast(new int[]{x, y - 1});
        }


    }


}
