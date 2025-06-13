package org.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2023-05-17 21:06
 **/
public class Main6 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int target = in.nextInt();

            double sqrt = Math.sqrt(target);
            for (int i = 2; i <= sqrt; i++) {
                if (target % i != 0) {
                    continue;
                }

                System.out.print(i + " ");
                target = target / i;
                i--;
            }

            System.out.println(target > 1 ? target : "");
        }
    }
}
