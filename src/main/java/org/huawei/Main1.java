package org.huawei;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 * 示例1
 * 输入：
 * hello nowcoder
 * 复制
 * 输出：
 * 8
 * 说明：
 * 最后一个单词为nowcoder，长度为8
 * @author: caiqiang
 * @create: 2023-05-16 21:38
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();

            String[] s1 = s.split(" ");
            String s2 = s1[s1.length - 1];
            System.out.println(s2.length());

        }
    }
}
