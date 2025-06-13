package org.lcr;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution125 {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

class CQueue {
    private final Queue<Integer> queue;

    public CQueue() {
        queue = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        queue.add(value);
    }

    public int deleteHead() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();

    }
}