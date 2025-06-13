package org.lcr;

import org.caiqiang.pojo.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution171 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null || headB != null){
            if (headA != null){
                if (set.contains(headA)){
                    return headA;
                }else {
                    set.add(headA);
                }
                headA = headA.next;
            }
            if (headB != null){
                if (set.contains(headB)){
                    return headB;
                }else {
                    set.add(headB);
                }
                headB = headB.next;
            }
        }
        return null;
    }
}
