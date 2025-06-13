package org.caiqiang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution51_3 {
    public static void main(String[] args) {
        Solution51_3 solution513 = new Solution51_3();
        System.out.println(solution513.solveNQueens(4));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        int[][] board = new int[n][n];
        dfs(result, deque, board, n, 0);
        return result;
    }

    private void dfs(List<List<String>> result, Deque<String> deque, int[][] board, int n, int index) {
        if (index >= n) {
            // 满足则转化输出
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (manzu(board, index, j)) {
                board[index][j] = 1;
                deque.addLast(caseString(n, j));
                dfs(result, deque, board, n, index + 1);
                board[index][j] = 0;
                deque.removeLast();
            }
        }
    }

    private String caseString(int n, int y) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == y) {
                s.append("Q");
            } else {
                s.append(".");
            }
        }
        return s.toString();
    }

    private boolean manzu(int[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] != 0) {
                return false;
            }
            if (board[x][i] != 0) {
                return false;
            }
            // 是否在同一斜线
            for (int j = 0; j < board[i].length; j++) {
                if (i != x && j != y && board[i][j] == 1) {
                    if (i + j == x + y) {
                        return false;
                    }
                    if (i - j == x - y) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
