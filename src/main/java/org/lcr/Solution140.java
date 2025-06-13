package org.lcr;

import org.caiqiang.pojo.ListNode;

public class Solution140 {
    public static void main(String[] args) {
        Solution140 solution140 = new Solution140();
        System.out.println(solution140.trainingPlan(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 5));
        System.out.println(solution140.trainingPlan(new ListNode(1),1));
    }
    // 1、快慢指针
    // 2、列表反转
    public ListNode trainingPlan(ListNode head, int cnt) {
        // 快慢指针
        ListNode right = head;
        ListNode left = null;
        if (right == null) {
            return null;
        }
        int count = 0;

        while (right != null) {
            if (count == cnt) {
                left = head;
            }
            right = right.next;
            if (left != null) {
                left = left.next;
            }
            count++;
        }
        if (left == null && count == cnt){
            left = head;
        }
        return left;
    }
}
