package org.huawei;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2023-05-18 23:38
 **/
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextDouble()) { // 注意 while 处理多个 case
            double a = in.nextDouble();

            BigDecimal bigDecimal = new BigDecimal(String.valueOf(a));

            BigDecimal multiply = bigDecimal.multiply(new BigDecimal("1"));
            System.out.println(multiply.setScale(0, RoundingMode.HALF_UP).intValue());

        }
    }
}
