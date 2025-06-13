package org.caiqiang;

//92. 反转链表 II
//中等
//相关标签
//相关企业
//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
//
//
//示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
//示例 2：
//
//输入：head = [5], left = 1, right = 1
//输出：[5]
//
//
//提示：
//
//链表中节点数目为 n
//1 <= n <= 500
//-500 <= Node.val <= 500
//1 <= left <= right <= n
public class Solution92 {
    public static void main(String[] args) {
        Solution92 solution92 = new Solution92();
//        System.out.println(solution92.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3, 4));
        System.out.println(solution92.reverseBetween(new ListNode(3, new ListNode(5)), 1, 2));
    }

    // 理解错题目了，他是反转left到right到链表，我写成互换left和right了
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode newHead = head;
        int count = 0;
        ListNode leftPre = null;
        ListNode rightPre = null;

        while (newHead != null && rightPre == null) {
            count++;
            if (left != 1 && count + 1 == left) {
                leftPre = newHead;
            }
            if (count + 1 == right) {
                rightPre = newHead;
            }
            newHead = newHead.next;
        }
        assert rightPre != null;
        ListNode rightNode = rightPre.next;
        ListNode rightNextNode = rightNode.next;
        if (leftPre == null) {
            if (right - left == 1) {
                head.next = rightNode.next;
                rightNode.next = head;
                return rightNode;
            }
            //left是头
            rightNode.next = head.next;
            rightPre.next = head;
            head.next = rightNextNode;
            return rightNode;
        } else {
            ListNode leftNode = leftPre.next;
            ListNode leftNextNode = leftNode.next;

            if (right - left == 1) {
                leftPre.next = rightNode;
                rightNode.next = leftNode;
                leftNode.next = rightNextNode;
                return head;
            }
            leftPre.next = rightNode;
            rightNode.next = leftNextNode;

            rightPre.next = leftNode;
            leftNode.next = rightNextNode;


            return head;
        }
    }
}
