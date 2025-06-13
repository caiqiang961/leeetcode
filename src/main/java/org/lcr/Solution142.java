package org.lcr;

import org.caiqiang.pojo.ListNode;

public class Solution142 {
    public static void main(String[] args) {
        ListNode l1Head = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2Head = new ListNode(1,new ListNode(3,new ListNode(4)));
        Solution142 solution142 = new Solution142();
        System.out.println(solution142.trainningPlan(l1Head, l2Head));
    }
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        ListNode result = new ListNode();
        ListNode head = result;

        while (l1Head != null || l2Head != null) {
            if (l1Head != null && l2Head != null) {
                if (l1Head.val >= l2Head.val) {
                    head.next = new ListNode(l2Head.val);
                    l2Head = l2Head.next;
                } else {
                    head.next = new ListNode(l1Head.val);
                    l1Head = l1Head.next;
                }
            }else if (l1Head != null) {
                head.next = new ListNode(l1Head.val);
                l1Head = l1Head.next;
            }else {
                head.next = new ListNode(l2Head.val);
                l2Head = l2Head.next;
            }
            head = head.next;
        }
        return result.next;
    }
}
