package org.caiqiang;

//69. x 的平方根
//简单
//相关标签
//相关企业
//提示
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
//由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
//注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
//
//
//示例 1：
//
//输入：x = 4
//输出：2
//示例 2：
//
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//
//
//提示：
//
//0 <= x <= 231 - 1
public class Solution69 {
    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
//        System.out.println(solution69.mySqrt(2147483647));
        System.out.println(solution69.mySqrt2(2147483647));

    }

    //暴力
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int target = x / 2 + 1;
        for (int i = 2; i <= target; i++) {
            int re = i * i;

            if (re > x || re < 0) {
                return i - 1;
            }
            if (re == x) {
                return i;
            }
        }
        return 0;
    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int target = x / 2 + 1;
        for (int i = 2; i <= target;) {
            int re = i * i;
            if (re == x){
                return re;
            }
            if (re >= target || re <= 0){
                for (int j = i; j <=target ; j++) {
                    int re1 = i * i;

                    if (re1 > x || re1 < 0) {
                        return j - 1;
                    }
                    if (re1 == x) {
                        return j;
                    }
                }
            }
            i = re;
        }


        return 0;

    }


    private int test(int start, int target, int x) {
        int curr = start * start;
        if (curr == x) {
            return start;
        }
        if (curr > target){
            for (int i = start; i <= target; i++) {

            }
        }
        if (curr < x) {
            int s = test(curr, target, x);
        }
        return 0;
    }
}
