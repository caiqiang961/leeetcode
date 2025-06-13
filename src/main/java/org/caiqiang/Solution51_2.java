package org.caiqiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
public class Solution51_2 {
    int cc = 0;
    public static void main(String[] args) {
        Solution51_2 solution51 = new Solution51_2();
        List<List<String>> lists = solution51.solveNQueens(9);
        for (List<String> list : lists) {
            System.out.println(list);
            System.out.println();
        }
        System.out.println(solution51.cc);
    }

    // 回溯算法 省空间...
    public List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            return Collections.singletonList(Collections.singletonList("Q"));
        }
        List<List<String>> result = new ArrayList<>();
        find(0, n, null, result);
        return result;
    }

    private void find(int x, int n, int[] currentArr, List<List<String>> result) {
        if (currentArr == null) {
            //参考51，这里是对原来的list<String>进行的改良,使用int[]可以节省好多的空间，数组下标为棋盘x坐标，数组值为棋盘y坐标，记录的为存Q的坐标
            currentArr = new int[n];
            Arrays.fill(currentArr, -1);
        }
        if (currentArr[n - 1] != -1) {
            result.add(getList(currentArr));
            return;
        }
        cc ++;
        for (int j = 0; j < n; j++) {
            if (!check(currentArr, x, j)) {
                continue;
            }
            currentArr[x] = j;
            find(x + 1, n, currentArr, result);
            //find之后返回到上一层，一定要将数据恢复致这一层的初始状态
            currentArr[x] = -1;
        }
    }

    private List<String> getList(int[] currentArr) {
        List<String> result = new ArrayList<>(currentArr.length);
        for (int i = 0; i < currentArr.length; i++) {
            String string = getString(currentArr[i], currentArr.length);
            result.add(string);
        }
        return result;
    }

    private String getString(int k, int n) {
        char[] c = new char[n];
        for (int i = 0; i < n; i++) {
            if (i == k) {
                c[i] = 'Q';
            } else {
                c[i] = '.';
            }
        }
       return new String(c);
    }


    private boolean check(int[] currentArr, int x, int y) {
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


        for (int i = 0; i < currentArr.length; i++) {
            //同一列 j相等
            if (currentArr[i] == y) {
                return false;
            }
            //同一 斜线 行下标与列下标只差相等；反斜线，行下标与列下标之和相等
            if (currentArr[i] != -1 && (i + currentArr[i] == x + y || i - currentArr[i] == x - y)){
                return false;
            }
        }
        return true;
    }


}
