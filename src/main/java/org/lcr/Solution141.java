package org.lcr;

import org.caiqiang.pojo.ListNode;

public class Solution141 {
    public ListNode trainningPlan(ListNode head) {
        ListNode result = null;
        ListNode lastNode = null;
        while (head != null) {
            result = new ListNode(head.val, lastNode);
            lastNode = result;
            head = head.next;
        }
        return result;
    }
}
