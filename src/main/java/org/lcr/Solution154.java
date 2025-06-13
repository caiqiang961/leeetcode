package org.lcr;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution154 {
    public static void main(String[] args) {
        Solution154 solution154 = new Solution154();
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(1);
        Node result = newHead;
        Node next;
        Node random;
        Map<Integer, Node> map = new HashMap<>();
        while (head != null) {
            newHead.val = head.val;
            map.put(newHead.val, newHead);

            if (head.next == null) {
                next = null;
            } else {
                next = map.get(head.next.val);
                if (next == null) {
                    next = new Node(head.next.val);
                    map.put(head.next.val, next);
                }
            }
            newHead.next = next;

            if (head.random == null) {
                random = null;
            } else {
                random = map.get(head.random.val);
                if (random == null) {
                    random = new Node(head.random.val);
                    map.put(head.random.val, random);
                }
            }
            newHead.random = random;

            head = head.next;
            newHead = newHead.next;
        }
        return result;
    }
}
