package org.caiqiang.jingdan;

//棋盘8皇后问题
public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        System.out.println(main1.start(8));
    }

    int count = 0;

    public int start(int num) {
        int[][] arr = new int[num][num];
        startFind(arr, 0);
        return count;
    }

    private void startFind(int[][] arr, int x) {
        if (x >= arr.length){
            count++;
            return;
        }
        int[] ints = arr[x];
        for (int j = 0; j < ints.length; j++) {
            if (!isSuss(arr, x, j)) {
                continue;
            }
            arr[x][j] = 1;
            startFind(arr, x + 1);
            arr[x][j] = 0;
        }
    }

    private boolean isSuss(int[][] arr, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (arr[i][y] == 1) {
                return false;
            }
            if (arr[x][i] == 1) {
                return false;
            }
            // i1,j1    i2,j2
            // i1 - j1 == i2 - j2 || i1 + j1 == i2 + j2   横纵计算 == 横纵计算
            // Math.abs(i1-i2) == Math.abs(j1-j2)         横横计算 == 纵纵计算
            // 3 2
            // 0 1 0 1   （ 0，1）  (0,3)
            // 0 0 1 0 （  1，2）
            //一纬数组，Math.abs(n-i) == Math.abs(array[n] - array[i])表示判断第n个皇后是否和第i皇后是否在同一斜线
            //一纬数组，x - i == array[x] - array[i] || x + i == array[x] + array[i]
            //不在同一斜线
            //二维数组，Math.abs(x - i) == Math.abs(y - k)
            //二维数组，x - y == i - k || x + y == i + k
            for (int k = 0; k < arr.length; k++) {
                if (arr[i][k] != 1){
                    continue;
                }
                if (x - y == i - k || x + y == i + k){
                    return false;
                }
            }
        }
        return true;
    }
}
