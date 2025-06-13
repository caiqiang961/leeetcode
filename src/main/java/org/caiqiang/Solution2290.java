package org.caiqiang;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2290 {
    public int minimumObstacles(int[][] grid) {
        int[][] dis = new int[grid.length][grid[0].length];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        return bfs(grid, new ArrayDeque<>(), dis);
    }

    private final int[][] finArr = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 思想是 需要最少移动次数，那就存储最少移动次数
    private int bfs(int[][] grid, Deque<int[]> deque, int[][] dis) {

        deque.addLast(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] ints1 = deque.pollFirst();
            int x = ints1[0];
            int y = ints1[1];


            for (int[] ints : finArr) {
                int nx = ints[0] + x;
                int ny = ints[1] + y;
                //grid[x][y]正好是0或者1，可以直接加
                if (nx >= 0 && nx <= dis.length - 1 && ny >= 0 && ny <= dis[0].length - 1 && dis[x][y] + grid[x][y] < dis[nx][ny]) {
                    dis[nx][ny] = dis[x][y] + grid[x][y];
                    if (grid[x][y] == 0){
                        deque.addFirst(new int[]{nx, ny});
                    }else {
                        deque.addLast(new int[]{nx, ny});
                    }

                }

            }

        }
        return dis[dis.length - 1][dis[0].length - 1];
    }
}
