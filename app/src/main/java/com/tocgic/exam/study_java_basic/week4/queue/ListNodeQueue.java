package com.tocgic.exam.study_java_basic.week4.queue;

import com.tocgic.exam.study_java_basic.week4.linked_list.LinkedList;
import com.tocgic.exam.study_java_basic.week4.linked_list.ListNode;

/**
 * ## 과제 5. Queue를 구현하세요.
 *
 * - ListNode를 사용해서 한번.
 */
public class ListNodeQueue {
    private final LinkedList linkedList;
    private final ListNode head;

    public ListNodeQueue() {
        this.linkedList = new LinkedList();
        head = new ListNode(0);
    }

    public void push(int data) {
        linkedList.add(head, new ListNode(data), linkedList.getSize(head) - 1);
    }

    public int pop() {
        int data = -1;
        int stackSize = linkedList.getSize(head);
        if (stackSize > 1) {
            ListNode node = linkedList.remove(head, 1);
            data = node.getData();
        }
        return data;
    }

}
