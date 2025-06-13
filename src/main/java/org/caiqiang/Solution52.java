package org.caiqiang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringJoiner;

//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
//示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//示例 2：
//
//输入：n = 1
//输出：[["Q"]]
//
//
//提示：
//
//1 <= n <= 9
public class Solution52 {
    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        System.out.println(solution52.totalNQueens(8));

    }

    int count = 0;

    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }
        find(0, n, null);
        return count;
    }
    // 回溯算法

    private void find(int x, int n, Deque<String> currentQueue) {
        if (currentQueue == null) {
            currentQueue = new ArrayDeque<>(n);
        }
        if (currentQueue.size() == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!check(currentQueue, x, j)) {
                continue;
            }
            currentQueue.addLast(getString(j, n));
            find(x + 1, n, currentQueue);
            currentQueue.removeLast();
        }
    }

    private String getString(int k, int n) {
        StringJoiner stringJoiner = new StringJoiner("");
        for (int i = 0; i < n; i++) {
            if (i == k) {
                stringJoiner.add("Q");
            } else {
                stringJoiner.add(".");
            }
        }
        return stringJoiner.toString();
    }

    private boolean check(Deque<String> currentQueue, int x, int y) {
        if (currentQueue == null || currentQueue.size() == 0) {
            return true;
        }
        ArrayList<String> currentList = new ArrayList<>(currentQueue);

        int n = currentList.get(0).length();
        String[][] arr = new String[currentList.size()][n];
        for (int j = 0; j < currentList.size(); j++) {
            arr[j] = currentList.get(j).split("");
        }
        //开始判断
        //同一行 i相等,不用判断
        //同一列 j相等
        //同一 斜线 行下标与列下标只差相等；反斜线，行下标与列下标之差相等

        //行
//        for (int j = 0; j < n; j++) {
//            //遍历列，判断行
//            if (arr[x][j].equals("Q")) {
//                return false;
//            }
//        }
        //列

        for (int i = 0; i < arr.length; i++) {
            //遍历行，判断列
            if (arr[i][y].equals("Q")) {
                return false;
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (i - j == x - y && arr[i][j].equals("Q")) {
                    return false;
                }
                if (i + j == x + y && arr[i][j].equals("Q")) {
                    return false;
                }
            }
        }
        return true;
    }


}
