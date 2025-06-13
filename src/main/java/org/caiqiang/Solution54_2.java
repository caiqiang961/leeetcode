package org.caiqiang;


import java.util.ArrayList;
import java.util.List;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
// 1 2 3
// 4 5 6
// 7 8 9

//1 2 3 6 9 8 7 4 5
public class Solution54_2 {

    public static void main(String[] args) {
        Solution54_2 solution54_2 = new Solution54_2();
//        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] a = new int[][]{{1,  2,  3,  4,  5},
                                {6,  7,  8,  9,  10},
                                {11, 12, 13, 14, 15},
                                {16, 17, 18, 19, 20},
                                {21, 22, 23, 24, 25}};
        System.out.println(solution54_2.spiralOrder(a));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        int index;
        int count = 0;
        int sum = matrix.length * matrix[0].length;

        while (count != sum) {

            //左
            index = left;
            while (index <= right) {
                result.add(matrix[top][index]);
                index++;
                count++;
                if (count == sum){
                    return result;
                }
            }
            //下
            index = top + 1;
            while (index <= bottom) {
                result.add(matrix[index][right]);
                index++;
                count++;
                if (count == sum){
                    return result;
                }
            }
            //左
            index = right - 1;
            while (index >= left) {
                result.add(matrix[bottom][index]);
                index--;
                count++;
                if (count == sum){
                    return result;
                }
            }
            //上
            index = bottom - 1;
            while (index >= top + 1) {
                result.add(matrix[index][left]);
                index--;
                count++;
                if (count == sum){
                    return result;
                }
            }
            top ++;
            left ++;
            bottom --;
            right --;
        }


        return result;
    }


}
