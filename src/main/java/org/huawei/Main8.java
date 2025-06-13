package org.huawei;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2023-05-18 23:47
 **/
public class Main8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Map<Integer, Integer> map = new HashMap<>();
        while (in.hasNextLine()) { // 注意 while 处理多个 case

            int num = Integer.parseInt(in.nextLine());
            for (int i = 0; i < num; i++) {
                String target = in.nextLine();
                String[] targetArr = target.split(" ");
                Integer key = Integer.valueOf(targetArr[0]);
                Integer value = Integer.valueOf(targetArr[1]);
                Integer currentValue = map.get(key);
                currentValue = currentValue == null ? 0 : currentValue;
                map.put(key, currentValue + value);

            }
            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            list.forEach(l -> {
                Integer integer = map.get(l);
                System.out.println(l + " " + integer);
            });

            map.clear();

        }
    }
}
