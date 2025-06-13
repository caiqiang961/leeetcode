package org.lcr;

import java.util.HashMap;
import java.util.Map;

public class Solution120 {
    public int findRepeatDocument(int[] documents) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int document : documents) {
            // 如果不存在则put1，如果存在则+1，并获取结果
            int value = map.compute(document, (k, oldV) -> {
                if (oldV == null) return 1;
                return oldV + 1;
            });
            if (value > 1) {
                return document;
            }
        }
        return -1;
    }
}
