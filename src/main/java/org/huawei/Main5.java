package org.huawei;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2023-05-17 19:18
 **/
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            if (s.length() == 0){
                continue;
            }
            if (!s.startsWith("0x") && !s.startsWith("0X")){
                continue;
            }
            String number = s.substring(2);

            System.out.println(Integer.parseInt(number, 16));

        }
    }
}
