package org.caiqiang;

import java.util.*;

public class Solution51_3_youhua {
    public static void main(String[] args) {
        Solution51_3_youhua solution513 = new Solution51_3_youhua();
        System.out.println(solution513.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        int[] board = new int[n];
        Arrays.fill(board, -1);
        dfs(result, deque, board, n, 0);
        return result;
    }

    private void dfs(List<List<String>> result, Deque<String> deque, int[] board, int n, int index) {
        if (index >= n) {
            // 满足则转化输出
            result.add(caseResult(board));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (manzu(board, index, j)) {
                board[index] = j;
                dfs(result, deque, board, n, index + 1);
                board[index] = -1;
            }
        }
    }

    private List<String> caseResult(int[] board) {
        List<String> result = new ArrayList<>();

        for (int b : board) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (j == b) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            result.add(s.toString());
        }
        return result;
    }

    private boolean manzu(int[] board, int x, int y) {
        if (x == 0) {
            return true;
        }
        for (int i = 0; i < x; i++) {
            if (board[i] == y) {
                return false;
            }
            if (i + board[i] == x + y) {
                return false;
            }
            if (i - board[i] == x - y) {
                return false;
            }
        }
        return true;
    }
}
