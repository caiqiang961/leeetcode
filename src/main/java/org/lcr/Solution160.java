package org.lcr;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution160 {
}

class MedianFinder {
    private final List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() % 2 != 0) {
            return list.get(list.size() / 2);
        }
        int x = list.size() / 2;
        BigDecimal decimal = new BigDecimal(String.valueOf(list.get(x - 1) + list.get(x)));
        return decimal.divide(new BigDecimal("2"), 1, RoundingMode.HALF_UP).doubleValue();

    }
}