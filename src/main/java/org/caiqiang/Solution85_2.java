package org.caiqiang;

public class Solution85_2 {
    public static void main(String[] args) {
        Solution85_2 solution85_2 = new Solution85_2();
        System.out.println(solution85_2.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(solution85_2.maximalRectangle(new char[][]{
                {'1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '0', '0', '0'},
                {'0', '1', '1', '1', '1', '0', '0', '0'}}));
    }

    // 纯暴力解法,每次遍历一个左上角顶点，然后向全局遍历，找一个最大值
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];
                if (current == '0') {
                    continue;
                }
                res = Math.max(res, forAllow(i, j, matrix));
            }
        }
        return res;
    }

    private int forAllow(int leftX, int leftY, char[][] matrix) {
        int res = 0;
        for (int i = leftX; i < matrix.length; i++) {
            for (int j = leftY; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                res = Math.max(res, suan(leftX, leftY, i, j, matrix));
            }
        }
        return res;
    }

    private int suan(int leftX, int leftY, int rightX, int rightY, char[][] matrix) {
        if (allow(leftX, leftY, rightX, rightY, matrix)) {
            return (rightY - leftY + 1) * (rightX - leftX + 1);
        }
        return 0;
    }

    private boolean allow(int leftX, int leftY, int rightX, int rightY, char[][] matrix) {
        for (int i = leftX; i <= rightX; i++) {
            for (int j = leftY; j <= rightY; j++) {
                if (matrix[i][j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}
