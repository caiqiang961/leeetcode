package org.caiqiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:编写一个程序，通过填充空格来解决数独问题。 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 * <p>
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2023-02-03 18:40
 **/
public class Solution37 {

    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        char[][] board = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solution37.solveSudoku(board);
        solution37.sout(board);
    }

    public void solveSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }

        for (int i = 0; i < 9; i++) {
            if (fx2(0, 0, board, (char) ('1' + i))) {
                return;
            }
        }
    }


    private boolean fx2(int i, int j, char[][] board, char k) {
        if (k > '9') {
            return false;
        }

        if (i > 8 || j > 8) {
            return true;
        }



        if (!isValid(i, j, board, k)){
            fx2(i, j, board, (char) (k + 1));
        }else {
            board[i][j] = k;

            //   +1
            if (j == 8) {
                i = i + 1;
                j = 0;
            } else {
                j++;
            }
            fx2(i, j, board, '1');

        }


        return true;
    }


    private boolean isValid(int i, int j, char[][] board, char k) {
        if (k > '9') {
            return false;
        }
        //遍历行是否出现
        for (int l = 0; l < j; l++) {
            if (board[i][l] == k) {
                return false;
            }

        }
        for (int l = 0; l < i; l++) {
            if (board[l][j] == k) {
                return false;
            }
        }
        int i3 = (i / 3) * 3;
        int j3 = (j / 3) * 3;

        if (i==0){
            //循环第0行   j列且不包含j
           if (j != 0){
               for (int l = 0; l < j; l++) {
                   if (board[0][l] == k) return false;
               }
           }
        }
        if (i > 0){

            //循环前i- 1行的全部，和第i行的前j列且不包含j
            for (int m = i3; m <= i; m++) {
                for (int n = j3; n <= j3 + 2; n++) {
                    if (m == i && n == j){
                        break;
                    }
                    if (board[m][n] == k) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    private void sout(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
