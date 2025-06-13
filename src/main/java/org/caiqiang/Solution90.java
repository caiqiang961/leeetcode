package org.caiqiang;

import java.util.*;

public class Solution90 {
    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        System.out.println(solution90.subsetsWithDup(new int[]{1,2,2}));
//        System.out.println(solution90.subsetsWithDup(new int[]{4,4,4,1,4}));
//        List<Integer> objects = new MyList<>(new ArrayDeque<>());
//        objects.add(4);
//        objects.add(1);
//        List<Integer> objects1 = new MyList<>(new ArrayDeque<>());
//        objects1.add(1);
//        objects1.add(4);
////        List<Integer> objects3 = new MyList<>(new ArrayDeque<>());
////        objects3.add(4);
////        objects3.add(1);
//
//        Set<List<Integer>> set = new HashSet<>();
//        System.out.println(objects.hashCode());
//        System.out.println(objects1.hashCode());
////        System.out.println(objects3.hashCode());
//
//        set.add(objects);
//        set.add(objects1);
////        set.add(objects3);
//        System.out.println(set);
    }


    //set去重太狠了,不能用set，把4,4,1和1,4,4也给当作重复了,这样不行

    // set 先比较hash不相同则直接加入，相同则再比较eq，不相同则加入
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
//        List<MyList<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        start(nums, 0, deque, result);
        return new ArrayList<>(result);
    }

    private void start(int[] nums, int index, Deque<Integer> deque, Set<List<Integer>> result) {

        MyList<Integer> integers = new MyList<>(deque);
        Collections.sort(integers);
        result.add(integers);
        for (int i = index; i < nums.length; i++) {
            deque.addLast(nums[i]);
            start(nums, i + 1, deque, result);
            deque.removeLast();
        }
    }

    static class MyList<T> extends ArrayList<T> {
        public MyList(Deque<T> deque) {
            super(deque);
        }
        // set 先比较hash不相同则直接加入，相同则再比较eq，不相同则加入
//        @Override
//        public int hashCode() {
//            return super.hashCode();
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (o == this) return true;
//            if (!(o instanceof List)) return false;
//            List<Integer> newList = (List<Integer>) o;
//            Collections.sort(newList);
//            Collections.sort((List<Integer>) this);
//            int index = 0;
//            while (index < newList.size()){
//                if (newList.get(index) != this.get(index)){
//                    return false;
//                }
//                index++;
//            }
//            return true;
//        }
    }
}
