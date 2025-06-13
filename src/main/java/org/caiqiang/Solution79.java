package org.caiqiang;

public class Solution79 {
    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        System.out.println(solution79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(solution79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

    //ABCB
//  'A', 'B', 'C', 'E'
//  'S', 'F', 'C', 'S'
//  'A', 'D', 'E', 'E'
    public boolean exist(char[][] board, String word) {
        int[][] arr = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (start(board, word, i, j, 0, arr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean start(char[][] board, String word, int x, int y, int currentIndex, int[][] arr) {
        if (currentIndex >= word.length()) {
            return true;
        }
        char currentChar = word.charAt(currentIndex);

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || arr[x][y] == 1 || board[x][y] != currentChar) {
            return false;
        }
        arr[x][y] = 1;
        // 下一次递归 下一个字母
        boolean a = start(board, word, x, y + 1, currentIndex + 1, arr) ||
                start(board, word, x, y - 1, currentIndex + 1, arr) ||
                start(board, word, x + 1, y, currentIndex + 1, arr) ||
                start(board, word, x - 1, y, currentIndex + 1, arr);
        arr[x][y] = 0;
        return a;
    }
}
