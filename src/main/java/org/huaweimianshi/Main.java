package org.huaweimianshi;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2023-06-16 20:27
 **/
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.canConstruct("aaa", "abbab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            String key = String.valueOf(magazine.charAt(i));
            map.merge(key, 1, (oldValue, newValue) -> oldValue + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            String target = String.valueOf(ransomNote.charAt(i));
            if (map.containsKey(target)) {
                Integer integer = map.get(target);
                if (integer <= 0){
                    return false;
                }
                map.put(target,map.get(target) - 1);
            } else {
                return false;
            }
        }
        return true;


    }
}
