package org.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @program: leetcode
 * @description:描述 明明生成了
 * �
 * N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 * <p>
 * 数据范围：
 * 1
 * ≤
 * �
 * ≤
 * 1000
 * <p>
 * 1≤n≤1000  ，输入的数字大小满足
 * 1
 * ≤
 * �
 * �
 * �
 * ≤
 * 500
 * <p>
 * 1≤val≤500
 * 输入描述：
 * 第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
 * 输出描述：
 * 输出多行，表示输入数据处理后的结果
 * <p>
 * 示例1
 * 输入：
 * 3
 * 2
 * 2
 * 1
 * 复制
 * 输出：
 * 1
 * 2
 * 复制
 * 说明：
 * 输入解释：
 * 第一个数字是3，也即这个小样例的N=3，说明用计算机生成了3个1到500之间的随机整数，接下来每行一个随机数字，共3行，也即这3个随机数字为：
 * 2
 * 2
 * 1
 * 所以样例的输出为：
 * 1
 * 2
 * @author: caiqiang
 * @create: 2023-05-16 22:17
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Set<Integer> set = new LinkedHashSet<>();
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            for (int i = 0; i < num; i++) {
                int a = in.nextInt();
                set.add(a);
            }
            ArrayList<Integer> integers = new ArrayList<>(set);
            Collections.sort(integers);
            integers.forEach(System.out::println);
            set.clear();

        }
    }

    private static void main2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {

            boolean[] stu = new boolean[1001];
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(str);
            for (int i = 0; i < n; i++)
                stu[Integer.parseInt(bf.readLine())] = true;
            for (int i = 0; i < 1001; i++)
                if (stu[i])
                    sb.append(i).append("\n");
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
