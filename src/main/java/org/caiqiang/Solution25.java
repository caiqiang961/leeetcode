package org.caiqiang;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2022-03-16 18:26
 **/
public class Solution25 {

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
//        ListNode header7 = new ListNode(2);
//        ListNode header6 = new ListNode(2,header7);
        ListNode header5 = new ListNode(5);
        ListNode header4 = new ListNode(4,header5);
        ListNode header3 = new ListNode(3,header4);
        ListNode header2 = new ListNode(2,header3);
        ListNode header = new ListNode(1,header2);
        System.out.println(solution25.reverseKGroup(header,1));
    }



    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode newHead ;

        ListNode tail = null;
        ListNode result = null;
        int count = 1;

        ListNode firstHead = null;
        while (start != null){
            if (firstHead == null){
                firstHead = start;
            }
           if (count == k){
               newHead = start.next;
               start.next = null;
               ListNode listNode = reverseKGroup1(firstHead, 100000000);
               if (result == null){
                   result = listNode;
               }
               if (tail == null){
                   tail = firstHead;
                   firstHead = null;
               }else {
                   tail.next = listNode;
                   tail = firstHead;
                   firstHead = null;
               }
               start = newHead;
               count = 0;
           }else {
               start = start.next;
           }
           count++;
        }
        if (firstHead != null){
            tail.next = firstHead;
        }
        return result;
    }


    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k <= 1){
            return head;
        }
        ListNode start = head;
        ListNode newHead = null;
        ListNode temp;
        ListNode oldHead = null;
//        ListNode oldHead = null;
        int count = 1;
        while (start != null){
            if (count > k){
                break;
            }
            if (newHead == null){
                newHead = start;
                oldHead = start;
                start = start.next;
            }else {
                temp = start.next;

                start.next = newHead;

                oldHead.next = temp;

                newHead = start;

                start = temp;
            }
           count++;
        }
        return newHead;
    }
}
