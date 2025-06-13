package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

public class Solution108 {
    public static void main(String[] args) {

        Solution108 solution108 = new Solution108();
        System.out.println(solution108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int mid = (left + right + 1) / 2 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
