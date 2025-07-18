package org.caiqiang;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description:请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *  
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：false
 * 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2023-02-02 18:16
 **/
public class Solution36 {

    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        char[][] board = new char[][]{
                new char[]{'5','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'},
        };

        System.out.println(solution36.isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (!isValid(i, j, board, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    //i=1 j=2
    private boolean isValid(int i, int j, char[][] board, char target) {
        if (target != '.'){
            //判断列
            for (int k = i + 1; k < 9; k++) {
                if (board[k][j] == target) {
                    return false;
                }
            }

            //判断行
            for (int k = j + 1; k < 9; k++) {
                if (board[i][k] == target) {
                    return false;
                }
            }
        }


        //判断三宫格
        if ((i + 1) % 3 == 0 && (j + 1) % 3 == 0) {
            Set<Character> set = new HashSet<>(9);
            for (int k = i - 2; k <= i; k++) {
                for (int l = j - 2; l <= j; l++) {
                    char cur = board[k][l];
                    if (cur != '.'){
                        int oldSize = set.size();
                        set.add(cur);
                        if (oldSize == set.size()){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
