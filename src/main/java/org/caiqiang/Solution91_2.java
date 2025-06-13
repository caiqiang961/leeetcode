package org.caiqiang;

//91. 解码方法
//已解答
//中等
//相关标签
//相关企业
//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
//"1" -> 'A'
//
//"2" -> 'B'
//
//...
//
//"25" -> 'Y'
//
//"26" -> 'Z'
//
//然而，在 解码 已编码的消息时，你意识到有许多不同的方式来解码，因为有些编码被包含在其它编码当中（"2" 和 "5" 与 "25"）。
//
//例如，"11106" 可以映射为：
//
//"AAJF" ，将消息分组为 (1, 1, 10, 6)
//"KJF" ，将消息分组为 (11, 10, 6)
//消息不能分组为  (1, 11, 06) ，因为 "06" 不是一个合法编码（只有 "6" 是合法的）。
//注意，可能存在无法解码的字符串。
//
//给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。如果没有合法的方式解码整个字符串，返回 0。
//
//题目数据保证答案肯定是一个 32 位 的整数。
//示例 1：
//
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
//示例 2：
//
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//示例 3：
//
//输入：s = "06"
//输出：0
//解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
//
//
//提示：
//
//1 <= s.length <= 100
//s 只包含数字，并且可能包含前导零。
public class Solution91_2 {
    public static void main(String[] args) {
        Solution91_2 solution91_2 = new Solution91_2();
//        System.out.println(solution91_2.numDecodings("111111111111111111111111111111111111111111111"));
        System.out.println(solution91_2.numQingWa(9));
        System.out.println(solution91_2.numQingWa1(9));
//        System.out.println(solution91_2.numDecodings("11"));
    }

    //有num阶楼梯，青蛙每次可以跳1阶或2阶，一共有多少种跳法
    //f(0) = 1
    //f(1) = 1
    //f(2) = f(0) + f(1)
    //...
    //f(i) = f(i - 1) + f(i - 2)
    public int numQingWa(int num) {
        int[] arr = new int[num + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i -2];
        }
        return arr[num];
    }

    public int numQingWa1(int num) {
       if (num == 0) return 1;
       if (num == 1) return 1;
       return numQingWa1(num - 1) + numQingWa1(num - 2);
    }

    //可以想象为青蛙跳台阶，什么情况下只能跳1节，什么情况下只能跳2节，什么情况下一节或俩节都可以跳
    // 前提f(0) = 1   | "1"   1 f(1) = f(O) = 1
    //                 "11"    当前i自成1个，f(i) = f(i-1)
    //                         当前i与前1个成一对，f(i) = f(i - 2)
    //                         当前i可以自成1，也可以与前1个成一堆f(i) =f(i-1) + f(i - 2)

    public int numDecodings(String s) {
        if (s.startsWith("0") || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int[] f = new int[s.length() + 1];
        f[0] = 1;//给定一个出始值为1,字符串长度为0时，为1种跳跃（编码数）方法，（台阶为0时，有1跳跃方法）
        f[1] = 1;//台阶为1时，有一种方法
        for (int i = 2; i < s.length() + 1; i++) {
            int index = i - 1;//i = 2时，字符串的第2个（下标为1）的字符
            char c = s.charAt(index);
            if (c != '0') {
                f[i] = f[i - 1];
            }
            char c0 = s.charAt(index - 1);
            if (c0 != '0') {
                int current = (c0 - '0') * 10 + (c - '0');
                if (current >= 10 && current <= 26) {
                    //这里如果满足上面的条件 f[i] = f[i - 1]; //青蛙只能跳1节
                    // 则这里就是 f[i] = f[i - 1 ] + f[i - 2];,//这里就是青蛙跳台阶了，可以跳1或2
                    //否则就是f[i] =  f[i - 2];//青蛙只能跳2节
                    f[i] = f[i] + f[i - 2];
                }
            }
        }
        return f[s.length()];
    }


}
