package org.caiqiang;

// 二进制数求和
//示例 1：
//
//输入:a = "11", b = "1"
//输出："100"
//示例 2：
//
//输入：a = "1010", b = "1011"
//输出："10101"
public class Solution67 {
    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        System.out.println(solution67.addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        StringBuilder result = new StringBuilder();
        char aChar;
        char bChar;
        char xChar = '0';
        while (aIndex >= 0 || bIndex >= 0) {
            if (aIndex >= 0) {
                aChar = a.charAt(aIndex);
            } else {
                aChar = '0';
            }
            if (bIndex >= 0) {
                bChar = b.charAt(bIndex);
            } else {
                bChar = '0';
            }
            if (xChar == '0') {
                if (aChar == '1' && bChar == '1') {
                    xChar = '1';
                    result.insert(0, "0");
                }else {
                    if (aChar == '0' && bChar == '0') {
                        result.insert(0, "0");
                    }else {
                        result.insert(0, "1");
                    }
                }
            } else {
                if (aChar == '1' || bChar == '1') {
                    if (aChar == '1' && bChar == '1') {
                        result.insert(0, "1");
                    } else {
                        result.insert(0, "0");
                    }
                } else {
                    xChar = '0';
                    result.insert(0, "1");
                }
            }

            aIndex--;
            bIndex--;
        }
        if (xChar == '1') {
            result.insert(0, "1");
        }
        return result.toString();
    }
}
