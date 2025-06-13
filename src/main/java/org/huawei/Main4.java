package org.huawei;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * 示例1
 * 输入：
 * abc
 * 复制
 * 输出：
 * abc00000
 * @author: caiqiang
 * @create: 2023-05-16 22:33
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            StringBuilder s = new StringBuilder(in.nextLine());
            int length = s.length();
            if (length == 0){
                continue;
            }
            int x;
            if (length <= 8){
                 x = 8 - length;
            }else {
                x = length % 8;
                if (x != 0) {
                    x = 8 - x;
                }
            }



            if (x != 0){
                for (int i = 0; i < x; i++) {
                    s.append("0");
                }
            }
            for (int i = 0; i < s.length() ; i = i + 8) {
                System.out.println(s.substring(i, i + 8));
            }
        }
    }
}
