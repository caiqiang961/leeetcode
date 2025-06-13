package org.caiqiang;

//83. 删除排序链表中的重复元素
//给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
public class Solution83 {

    public static void main(String[] args) {
        Solution83 solution83 = new Solution83();
        System.out.println(solution83.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))))));
        System.out.println(solution83.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))))));
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode resultHead = head;
        ListNode nextHead = head.next;

        while (nextHead != null){
            if (head.val == nextHead.val){
                head.next = nextHead.next;
            }else {
                head = head.next;
            }
            nextHead = nextHead.next;
        }
        return resultHead;
    }
}
