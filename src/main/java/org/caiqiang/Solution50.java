package org.caiqiang;

import java.math.BigDecimal;
import java.math.RoundingMode;

//50. Pow(x, n)
//中等
//相关标签
//相关企业
//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
//
//
//
//示例 1：
//
//输入：x = 2.00000, n = 10
//输出：1024.00000
//示例 2：
//
//输入：x = 2.10000, n = 3
//输出：9.26100
//示例 3：
//
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
//
//
//提示：
//
//-100.0 < x < 100.0
//-231 <= n <= 231-1
//n 是一个整数
//要么 x 不为零，要么 n > 0 。
public class Solution50 {
    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
//        long l = System.currentTimeMillis();
//        System.out.println(solution50.myPow(-1.00001, 123456));
//        System.out.println(System.currentTimeMillis() - l);
//        long l2 = System.currentTimeMillis();
//        System.out.println(solution50.myPow1(-1.00001, 123456));
//        System.out.println(solution50.myPow1(0.00001, 2147483647));
        System.out.println(solution50.myPow1(2, -2147483648));
//        System.out.println(solution50.myPow1(2, 10));
//        System.out.println(System.currentTimeMillis() - l2);
//        System.out.println(solution50.myPow1(2, 10));
    }

    public double myPow1(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        BigDecimal org = new BigDecimal("1");
        if (x < 0 && n % 2 != 0) {
            org = new BigDecimal("-1");
        }
        x = Math.abs(x);
        BigDecimal de = null;
        boolean flag = false;
        if (n < 0) {
            de = new BigDecimal("1");
            if (n == Integer.MIN_VALUE){
                flag = true;
                n = Integer.MAX_VALUE;
            }else {
                n = -n;
            }
        }

        BigDecimal xDecimal = new BigDecimal(x + "");
        BigDecimal bigDecimal = multiplyBig(xDecimal, n);

        BigDecimal multiply = org.multiply(bigDecimal);
        if (de == null) {
            return multiply.doubleValue();
        } else {
            if (flag){
                return de.divide(multiply, 10, RoundingMode.HALF_UP).divide(xDecimal,10, RoundingMode.HALF_UP).doubleValue();
            }
            return de.divide(multiply, 10, RoundingMode.HALF_UP).doubleValue();
        }
    }

    private BigDecimal multiplyBig(BigDecimal x, int n) {
        BigDecimal result = x;
        if (n == 0) {
            return new BigDecimal("1");
        }
        int count = 1;
        while (count + count <= n) {
            if (count + count < 0){
                break;
            }
            count = count + count;
            result = result.multiply(result);
            result = result.setScale(10, RoundingMode.HALF_UP);
        }
        return result.multiply(multiplyBig( x, n - count));
    }


    //暴力算法，超时
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        BigDecimal org = new BigDecimal("1");
        if (x < 0 && n % 2 != 0) {
            org = new BigDecimal("-1");
            x = -x;
        }
        BigDecimal de = null;
        if (n < 0) {
            de = new BigDecimal("1");
            n = -n;
        }
        BigDecimal result = new BigDecimal("1");
        for (int i = 1; i <= n; i++) {
            result = result.multiply(new BigDecimal(x + ""));
        }
        BigDecimal multiply = org.multiply(result);
        if (de == null) {
            return multiply.doubleValue();
        } else {
            return de.divide(multiply, 10, RoundingMode.HALF_UP).doubleValue();
        }
    }

}
