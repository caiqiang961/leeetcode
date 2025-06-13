package org.jindonmainshi;

public class Main2 {
    public static void main(String[] args) {
        Main2 main2 = new Main2();
        System.out.println(main2.smallestIndex(new int[]{1, 10, 11}));
    }
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (sum(nums[i],i)){
                return i;
            }
        }
        return -1;
    }

    private boolean sum(int num, int index) {
        if (num < 0) {
            return false;
        }
        if (num < 10) {
            if (num != index) {
                return false;
            } else {
                return true;
            }
        }
        String s = String.valueOf(num);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result + Integer.parseInt(String.valueOf(s.charAt(i)));
            if (result > index) {
                return false;
            }
        }
        return result == index;
    }
}
