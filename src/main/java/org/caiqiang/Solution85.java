package org.caiqiang;

//85. 最大矩形
//困难
//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
public class Solution85 {
    public static void main(String[] args) {
        Solution85 solution85 = new Solution85();
//        System.out.println(solution85.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(solution85.maximalRectangle(new char[][]{
                {'1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','0','0','0'},
                {'0','1','1','1','1','0','0','0'}}));
    }

    // 把遍历到到每一个1为左上角顶点开始扩大
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];
                if (current == '0') {
                    continue;
                }
                // 右下角扩张
                int[] ints = startDouble(i, j, matrix);
                ints[1] = startY(i, j, ints[0], ints[1], matrix);
                ints[0] = startX(i, j, ints[0], ints[1], matrix);
                res = Math.max(res, (ints[1] - j + 1) * (ints[0] - i + 1));

            }
        }
        return res;
    }

    private int[] startDouble(int x, int y, char[][] matrix) {
        int rightX = x + 1;
        int rightY = y + 1;
        while (allow(x, y, rightX, rightY, matrix)) {
            rightX++;
            rightY++;
        }
        rightX--;
        rightY--;
        return new int[]{rightX, rightY};
    }

    // 横向+1 y+1
    private int startY(int x, int y, int rightX, int rightY, char[][] matrix) {
        rightY++;
        while (allow(x, y, rightX, rightY, matrix)) {
            rightY++;
        }
        rightY--;

        return rightY;
    }

    // 纵向+1 x+1
    private int startX(int x, int y, int rightX, int rightY, char[][] matrix) {
        rightX++;
        while (allow(x, y, rightX, rightY, matrix)) {
            rightX++;
        }
        rightX--;
        return rightX;
    }

    private boolean allow(int leftX, int leftY, int rightX, int rightY, char[][] matrix) {
        if (rightX >= matrix.length || rightY >= matrix[0].length) {
            return false;
        }
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
