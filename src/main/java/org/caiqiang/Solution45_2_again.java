package org.caiqiang;

public class Solution45_2_again {

    public static void main(String[] args) {
        Solution45_2_again solution45_2_again = new Solution45_2_again();
        System.out.println(solution45_2_again.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution45_2_again.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(solution45_2_again.jump(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution45_2_again.jump(new int[]{1, 1, 1, 1}));
        System.out.println(solution45_2_again.jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}));

    }
    //O(n) 每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到max_far位置的点）作为下次的起跳点 ！
    public int jump(int[] nums) {
        int count = 0;
        if (nums.length <= 1) {
            return count;
        }
        int nextIndex = nums[0];
        int index = 0;
        while (true) {
            count++;
            index = getIndex(nums,index + 1,index + nextIndex);
            if (index == -1){
                return count;
            }
            nextIndex = nums[index];
        }
    }

    private int getIndex(int[] nums,int startIndex ,int endIndex){
        if (endIndex >= nums.length - 1){
            return -1;
        }

        int result = nums[startIndex] + startIndex;
        int index = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (result <= nums[i] + i){
                result = nums[i] + i;
                index = i;
            }
        }
        return index;
    }
}
