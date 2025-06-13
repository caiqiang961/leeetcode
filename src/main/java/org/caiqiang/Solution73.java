package org.caiqiang;

public class Solution73 {
    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();
        int[][] arr = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution73.setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean[] xFlag = new boolean[matrix.length];
        boolean[] yFlag = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!xFlag[i]) {
                        xFlag[i] = true;
                    }
                    if (!yFlag[j]) {
                        yFlag[j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < xFlag.length; i++) {
            if (xFlag[i]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < yFlag.length; j++) {
            if (yFlag[j]) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
