package org.caiqiang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution380 {
    public static void main(String[] args) {
        int index = (int) (Math.random() * 10);
        System.out.println(index);
    }
}

class RandomizedSet {
    private Set<Integer> sets;
    private List<Integer> list;

    public RandomizedSet() {
        sets = new HashSet<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (sets.contains(val)){
            return false;
        }
        sets.add(val);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!sets.contains(val)){
            return false;
        }
        sets.remove(val);
        list.remove(new Integer(val));
        return true;
    }

    public int getRandom() {
        int size = sets.size();
        int index = (int) (Math.random() * size);
        return list.get(index);
    }
}


