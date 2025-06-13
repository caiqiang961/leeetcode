package org.lcr;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution134 {
    public static void main(String[] args) {
        Solution134 solution134 = new Solution134();
        System.out.println(solution134.myPow(2, 4));
    }
    // 超出时间限制
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int count = n;
        if (n < 0) {
            count = -n;
        }
        BigDecimal result = new BigDecimal(String.valueOf(x));
        BigDecimal bigDecimalTemp = new BigDecimal(String.valueOf(x));

        for (int i = 1; i < count; i++) {
            result = bigDecimalTemp.multiply(result);
        }
        if (n < 0) {
            BigDecimal decimal = new BigDecimal("1");
            result = decimal.divide(result, 10, RoundingMode.HALF_UP);
        }
        return result.doubleValue();
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n > 0) {
            return quickMul(x, n);
        } else {
            return 1.0 / quickMul(x, -n);
        }
    }

    private double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }


}
