package org.lcr;

import org.caiqiang.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution123 {
    public int[] reverseBookList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head !=null){
            list.add(head.val);
            head = head.next;
        }
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - 1 - i);
        }
        return result;
    }
}
