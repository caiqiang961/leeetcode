package org.lcr;

import org.caiqiang.pojo.ListNode;

public class Solution136 {
    public ListNode deleteNode(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode current = head.next;
        ListNode preNode = head;
        while (current != null) {
            if (current.val == val) {
                preNode.next = current.next;
                return head;
            }
            current = current.next;
            preNode = preNode.next;
        }
        return head;
    }
}
