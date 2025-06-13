package org.huawei;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:描述 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * <p>
 * 数据范围：
 * 1
 * ≤
 * �
 * ≤
 * 1000
 * <p>
 * 1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 * <p>
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 * <p>
 * 示例1
 * 输入：
 * ABCabc
 * A
 * 复制
 * 输出：
 * 2
 * @author: caiqiang
 * @create: 2023-05-16 21:54
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            String s1 = in.nextLine();
            char c = s1.charAt(0);
            boolean flag = false;
            char x = ' ';
            if (c >= a && c <= z) {
                flag = true;
                x = (char) (c + A - a);
            }
            if (c >= A && c <= Z) {
                flag = true;
                x = (char) (c - (A - a));
            }
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                if (flag) {
                    if (c1 == c || c1 == x) {
                        count++;
                    }
                }else {
                    if (c1 == c) {
                        count++;
                    }
                }
            }
            System.out.println(count);


        }

    }
}
