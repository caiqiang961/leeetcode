package org.caiqiang;
//48. 旋转图像
//中等
//相关标签
//相关企业
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
//你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//
//
//示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
//1 2 3
//4 5 6
//7 8 9
//
//00 03  01 13  02 23
//10 01  11 11  12 22
//20 00  21 10  22 20

//10 7 4 1
//11 8 5 2
//12 9 6 3
//示例 2：
//
//
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//
//提示：
//
//n == matrix.length == matrix[i].length
//1 <= n <= 20
//-1000 <= matrix[i][j] <= 1000
public class Solution48 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        solution48.rotate(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //第一行的第 xxx 个元素在旋转后恰好是倒数第一列的第 xxx 个元素。
    //
    //对于矩阵中的第二行而言，在旋转后，它出现在倒数第二列的位置：

    //对于矩阵中的第三行和第四行同理。这样我们可以得到规律：
    //int[3][4]
    //对于矩阵中第 iii 行的第 jjj 个元素，在旋转后，它出现在倒数第 iii 列的第 jjj 个位置。
    //使用了额外的一个存储数组
    public void rotate(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] arr = new int[x][y];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                arr[i][j] = matrix[i][j];
            }
        }
        //第 iii 行的第 jjj 个元素，在旋转后，它出现在倒数第 iii 列的第 jjj 个位置
        // i , j  ->   j , y - 1 - i
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][y - 1 - i] = arr[i][j];
            }
        }
    }
}
