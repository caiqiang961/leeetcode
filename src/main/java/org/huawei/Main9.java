package org.huawei;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2023-05-19 00:06
 **/
public class Main9 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        Set<String> set = new HashSet<>();
//        while (in.hasNextLine()) { // 注意 while 处理多个 case
//            String s = in.nextLine();
//            String[] split = s.split("");
//
//            for (int i = split.length - 1; i >= 0; i--) {
//                String s1 = split[i];
//                if (!set.contains(s1)){
//                    set.add(s1);
//                    System.out.print(s1);
//                }
//            }
//
//        }
//    }

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;

        int available = -1 ;
        while (available < 0){
            available = in.available()-1;
        }

        char[] chars = new char[available];
        while (available-- > 0) {
            chars[available] = (char) in.read();
        }
        StringBuilder resul = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (resul.lastIndexOf(String.valueOf(chars[i])) != -1){
                continue;
            }
            resul.append(chars[i]);
        }
        System.out.println(resul.toString());

    }

}
