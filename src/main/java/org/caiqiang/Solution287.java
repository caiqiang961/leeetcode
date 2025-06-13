package org.caiqiang;

public class Solution287 {
    public static void main(String[] args) {
        Solution287 solution287 = new Solution287();

    }

    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] ^ nums[j]) == 0) {
                    return nums[i];
                }
            }
        }
        return 0;
    }
}
