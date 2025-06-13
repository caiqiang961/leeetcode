package org.caiqiang;

//82. 删除排序链表中的重复元素 II
// 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
public class Solution82 {
    public static void main(String[] args) {
        Solution82 solution82 = new Solution82();
        System.out.println(solution82.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))))));
        System.out.println(solution82.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))))));
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode resultHead = head;
        ListNode leftHead = head;
        ListNode prdLeftHead = null;
        ListNode rightHead = head.next;

        while (rightHead != null) {
            if (leftHead.val == rightHead.val) {
                while (rightHead != null && leftHead.val == rightHead.val) {
                    rightHead = rightHead.next;
                }
                if (prdLeftHead == null) {
                    resultHead = rightHead;
                } else {
                    prdLeftHead.next = rightHead;
                }
                leftHead = rightHead;
            } else {
                prdLeftHead = leftHead;
                leftHead = leftHead.next;
            }
            if (rightHead != null) {
                rightHead = rightHead.next;
            }
        }
        return resultHead;
    }
}
