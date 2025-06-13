package org.caiqiang;

import java.util.Arrays;

public class Solution238 {
    public static void main(String[] args) {
        Solution238 solution238 = new Solution238();
        int[] ints = solution238.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));

    }
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0){
            return new int[0];
        }
        if (nums.length == 1){
            return new int[]{1};
        }

        int[] answer = new int[nums.length];
        int[] l = new int[nums.length];
        l[0] = 1;
        int[] r = new int[nums.length];
        r[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            l[i] = nums[i - 1] * l[i - 1];
        }
        for (int i = nums.length - 1; i > 0; i--) {
            r[i - 1] = r[i] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            answer[i] = r[i] * l[i];
        }

        return answer;
    }
}
