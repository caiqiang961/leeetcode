package org.caiqiang;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution547 {
    public static void main(String[] args) {
        Solution547 solution547 = new Solution547();
//        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] isConnected = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
//        System.out.println(solution547.findCircleNum(isConnected));
        System.out.println(solution547.findCircleNum1(isConnected));

    }


    // [1,0,0,1],
    // [0,1,1,0],
    // [0,1,1,1],
    // [1,0,1,1]
    private final int[][] ARR = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // dfs
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    result++;
                    dfs(isConnected, i, j);
                }
            }
        }
        return result;
    }
    // bfs
    public int findCircleNum1(int[][] isConnected) {

        return bfs(isConnected);
    }

    // [1,0,0,1],
    // [0,1,1,0],
    // [0,1,1,1],
    // [1,0,1,1]
    private void dfs(int[][] isConnected, int x, int y) {
        if (x < 0 || x >= isConnected.length || y < 0 || y >= isConnected[0].length) {
            return;
        }
        if (isConnected[x][y] == 2 || isConnected[x][y] == 0) {
            return;
        }

        // == 1
        isConnected[x][y] = 2;
        // 这样循环也ok，但是可以优化
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][y] == 1) {
                dfs(isConnected, i, y);
            }
        }
        for (int i = 0; i < isConnected[0].length; i++) {
            if (isConnected[x][i] == 1) {
                dfs(isConnected, x, i);
            }
        }
    }

    private int bfs(int[][] isConnected) {
        int con = isConnected.length;
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < con; i++) {
            if (isConnected[i][i] == 1){
                result++;
                deque.addLast(i);
                while (!deque.isEmpty()) {
                    Integer curr = deque.pollFirst();
                    for (int j = 0; j < con; j++) {
                        if (isConnected[curr][j] == 1) {
                            isConnected[curr][j] = 2;
                            deque.addLast(j);
                        }
                        if (isConnected[j][curr] == 1) {
                            isConnected[j][curr] = 2;
                            deque.addLast(j);
                        }
                    }
                }
            }

        }
        return result;
    }

}
