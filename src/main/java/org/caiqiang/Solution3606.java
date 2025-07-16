package org.caiqiang;

import java.util.*;

public class Solution3606 {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> list = new ArrayList<>();
        list.add("electronics");
        list.add("grocery");
        list.add("pharmacy");
        list.add("restaurant");
        List<String> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        // a-z、A-Z、0-9）和下划线（_）组成
        for (int i = 0; i < code.length; i++) {
            if (voliate(code[i], isActive[i])) {
                int finalI = i;
                map.compute(businessLine[i], (k, ov) -> {
                    if (ov == null) {
                        ov = new ArrayList<>();
                    }
                    ov.add(code[finalI]);
                    return ov;
                });
            }
        }
        // "electronics"、"grocery"、"pharmacy"、"restaurant" 类别排序
        list.forEach((l) -> {
            List<String> list1 = map.get(l);
            if (list1 != null && list1.size() != 0) {
                Collections.sort(list1);
                result.addAll(list1);
            }
        });
        return result;
    }

    private boolean voliate(String code, boolean isActive) {
        if (!isActive) {
            return false;
        }
        if (Objects.equals(code, "")) {
            return false;
        }
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            boolean va = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '_';
            if (!va) {
                return false;
            }
        }
        return true;
    }
}
