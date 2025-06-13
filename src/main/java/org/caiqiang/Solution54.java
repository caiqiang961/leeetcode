package org.caiqiang;


import java.util.ArrayList;
import java.util.List;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
// 1 2 3
// 4 5 6
// 7 8 9

//1 2 3 6 9 8 7 4 5
public class Solution54 {

    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution54.spiralOrder(a));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[][] arr = new int[matrix.length][matrix[0].length];

        test(result, matrix, arr, 0, 0, 0,0);
        return result;
    }

    //0 右
    //1 下
    //2 左
    //3 上
    private void test(List<Integer> result, int[][] matrix, int[][] arr, int x, int y, int z,int count) {
        if (x >= matrix.length || y >= matrix[0].length || x < 0 || y < 0 || arr[x][y] == -1) {
            switch (z) {
                case 0:
                    y = y - 1;
                    break;
                case 1:
                    x = x - 1;
                    break;
                case 2:
                    y = y + 1;
                    break;
                case 3:
                    x = x + 1;
                    break;
            }
            if (z == 3) {
                z = 0;
            } else {
                z++;
            }

        }
        if (arr[x][y] != -1) {
            result.add(matrix[x][y]);
            arr[x][y] = -1;
            count++;
            if (count == matrix.length*matrix[0].length){
                return;
            }
        }
        switch (z) {
            case 0:
                test(result, matrix, arr, x, y + 1, z,count);
                break;
            case 1:
                test(result, matrix, arr, x + 1, y, z,count);
                break;
            case 2:
                test(result, matrix, arr, x, y - 1, z,count);
                break;
            case 3:
                test(result, matrix, arr, x - 1, y, z,count);
                break;
        }
    }
}
