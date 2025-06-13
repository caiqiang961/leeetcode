package org.caiqiang;

import java.util.ArrayList;
import java.util.List;

//44. 通配符匹配
//困难
//相关标签
//相关企业
//给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
//'?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符序列（包括空字符序列）。
//判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
//示例 1：
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
//示例 2：
//输入：s = "aa", p = "*"
//输出：true
//解释：'*' 可以匹配任意字符串。
//示例 3：
//输入：s = "cb", p = "?a"
//输出：false
//解释：'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
//提示：
//0 <= s.length, p.length <= 2000
//s 仅由小写英文字母组成
//p 仅由小写英文字母、'?' 或 '*' 组成
public class Solution44 {
    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        solution44.isMatch("12jjizhkxxxxxccc3bnnaxz", "??jj?zh??**a****b**csda*??sasd*?b??a?z");
    }

    //"abc" "?*c"
    public boolean isMatch(String s, String p) {
        List<String> list = feng(p);
        Xtest match = isMatch(s, list);
        if (!match.result) {
            return false;
        }
        String tempStr = s;
        while (!match.s.equals(tempStr)) {
            tempStr = match.s;
            match = isMatch(match.s, list);
            if (!match.result) {
                return false;
            }
        }
        s = match.s;
        System.out.println(s);
        System.out.println(list);

        return false;
    }

    //xxxaxxxbxxcsdakksasdxxx
    //  a b csda ?? sasd
    private boolean isMatch1(String s, List<String> list) {
        int suffixNum = 0;
        int index = 0;
        int strLength = 0;
        String orgStr = s;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("*")) {
                continue;
            } else if (list.get(i).startsWith("?")) {
                suffixNum = list.get(i).length();
            } else {//是字母
                s = s.substring(index + strLength);
                index = s.indexOf(list.get(i));
                if (index == -1) {
                    return false;
                }
                if (index < suffixNum) {
                    return false;
                }
                strLength = list.get(i).length();
            }

        }
        return true;
    }


    //开头和结尾的判断
    private Xtest isMatch(String s, List<String> list) {
        if (list.get(0).startsWith("?")) {
            s = s.substring(list.get(0).length());
            list.remove(0);
        } else if (!list.get(0).startsWith("*")) {
            if (s.startsWith(list.get(0))) {
                s = s.substring(list.get(0).length());
                list.remove(0);
            } else {
                return new Xtest(false, s);
            }
        }


        if (list.get(list.size() - 1).startsWith("?")) {
            s = s.substring(0, s.length() - list.get(list.size() - 1).length());
            list.remove(list.size() - 1);
        } else if (!list.get(list.size() - 1).startsWith("*")) {
            if (s.endsWith(list.get(list.size() - 1))) {
                s = s.substring(0, s.length() - list.get(list.size() - 1).length());
                list.remove(list.size() - 1);
            } else {
                return new Xtest(false, s);
            }
        }


        return new Xtest(true, s);
    }

    private List<String> feng(String p) {
        List<String> list = new ArrayList<>();
        int index = 0;
        while (index < p.length()) {
            char c = p.charAt(index);
            if (c == '?') {
                int end = index + 1;
                for (int j = index; j < p.length(); j++) {
                    if (end >= p.length()) {
                        list.add(p.substring(index, end));
                        break;
                    }
                    char x = p.charAt(end);
                    if (x != '?') {
                        list.add(p.substring(index, end));
                        break;
                    } else {
                        end++;
                    }
                }
                index = end;
            } else if (c == '*') {
                int end = index + 1;
                for (int j = index; j < p.length(); j++) {
                    if (end >= p.length()) {
                        list.add(p.substring(index, end));
                        break;
                    }
                    char x = p.charAt(end);
                    if (x != '*') {
                        list.add(p.substring(index, end));
                        break;
                    } else {
                        end++;
                    }
                }
                index = end;
            } else {
                int end = index + 1;
                for (int j = index; j < p.length(); j++) {
                    if (end >= p.length()) {
                        list.add(p.substring(index, end));
                        break;
                    }
                    char x = p.charAt(end);
                    if (x == '*' || x == '?') {
                        list.add(p.substring(index, end));
                        break;
                    } else {
                        end++;
                    }
                }
                index = end;
            }
        }
        System.out.println(list);
        return list;
    }


    class Xtest {
        boolean result;
        String s;

        public Xtest(boolean result, String s) {
            this.result = result;
            this.s = s;
        }
    }

}
